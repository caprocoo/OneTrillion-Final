package com.onetrillion.trip.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onetrillion.trip.admin.AttachImageVO;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.impl.BoardService;

@Controller
@RequestMapping(value = "/adminProduct")
public class AdminProductController {

	@Autowired
	public BoardService service;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model) {
		List<BoardDTO> pdList = service.selectAll();
		model.addAttribute("pdList", pdList);
		return "adminProduct/adminPd";
	}

	// 관리자 상품 수정 페이지 이동
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyGet(@RequestParam("pd_seq") int pd_seq, Model model) {
		BoardDTO list = service.detail(pd_seq);
		model.addAttribute("list", list);
		return "adminProduct/adminPdModi";
	}

	// 관리자 상품 수정 완료(Ajax)
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modifyPost(@RequestParam("pd_seq") int pd_seq, Model model, BoardDTO dto) {
		model.addAttribute("pd_seq", pd_seq);
		service.modify(dto);
		return "redirect:/adminProduct/list.do";
	}

	// 관리자가 상품 삭제 완료(Ajax)
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String deletePost(BoardDTO dto) {
		service.delete(dto);
		return "redirect:/adminProduct/list.do";
	}

	// 관리자 상품 입력 페이지 이동
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String insertGet() {
		return "adminProduct/adminPdInput";
	}

	// 관리자 상품 입력 페이지 이동
	@RequestMapping(value = "/mini.do", method = RequestMethod.GET)
	public String mini(Model model) {
		List<BoardDTO> pdList = service.selectAll();
		model.addAttribute("pdList", pdList);
		return "adminProduct/adminPdMini";
	}

	// 관리자 상품 입력 완료
	@RequestMapping(value = "/input.do", method = RequestMethod.POST)
	public String insertPost(BoardDTO dto) {
		System.out.println(dto);
		int cnt = service.insert(dto);
		if (cnt > 0) {
			return "redirect:/adminProduct/list.do";
		}
		return "adminProduct/adminPdInput";
	}
	
	
/*
	@RequestMapping(value = "/uploadAjax.do", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // json데이터가 인코딩된 상태로 전송되게하는 속성
	public ResponseEntity<List<AttachImageVO>> uploadAjaxPost(MultipartFile pd_image) { // formData.append("pd_image", fileObj)의 key값 받아오기
		//System.out.println("파일업로드 컨트롤러 드러왔당");
		//System.out.println("파일 이름 : " + pd_image.getOriginalFilename());
		//System.out.println("파일 타입 : " + pd_image.getContentType());
		//System.out.println("파일 크기 : " + pd_image.getSize());

			// 파일이 이미지인지 체크해주는 코드
			File checkfile = new File(pd_image.getOriginalFilename());
			String type = null;
		
			try {
				type = Files.probeContentType(checkfile.toPath());
				System.out.println("MIME TYPE : "+ type);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(!type.startsWith("image")) { // 파일이 이미지가 아니면
				List<AttachImageVO> list = null; //list에 null값을 입력해줌
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST); // 상태가 400인 코드를 반환해줌
			}
		
		String uploadFolder = "C:\\onetrillion"; // 이미지 저장경로
		
		//날짜별로 저장해주는 코드 (일단 주석!)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		String datePath = str.replace("-", File.separator);
		
		File uploadPath = new File(uploadFolder); // 폴더 생성 
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		List<AttachImageVO> list = new ArrayList();
			
			// 이미지 정보 담는 객체 
			AttachImageVO vo = new AttachImageVO(); // 생성자로 초기화
			String uploadFileName = pd_image.getOriginalFilename(); // 파일 이름 설정
			vo.setFileName(uploadFileName);
			vo.setUploadPath(datePath);
			
			String uuid = UUID.randomUUID().toString(); // uuid 적용 파일 이름 
			vo.setUuid(uuid);
			uploadFileName = uuid + "_" + uploadFileName; // 기존 파일명 + uuid 적용 파일 이름 
			
			File saveFile = new File(uploadPath, uploadFileName); // 파일 위치, 파일 이름을 합친 File 생성
			System.out.println("saveFile"+saveFile);
			
			// 최종 파일 저장 
			try {
				pd_image.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			list.add(vo);

		// ResponseEntity를 이용해서 http 상태가 200일 때 http Body에 이미지정보가 담긴 List객체를 view페이지에 보내줌
		// ResponseEntity를 이용하면 상태코드와 http response 메시지를 조작할 수 있음
		ResponseEntity<List<AttachImageVO>> result = new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);
		
		return result;
	}*/

	
	
	// image 경로 설정
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(String fileName) {
//		System.out.println("여기 들어왔어~~");
//		System.out.println("fileName"+fileName);
		File file = new File("c:\\onetrillion\\" + fileName);
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
//			System.out.println("header : " + header);
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//			System.out.println("result : " + result);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	@RequestMapping(value = "/uploadAjax.do", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // json데이터가 인코딩된 상태로 전송되게하는 속성
	public ResponseEntity<List<AttachImageVO>> uploadAjaxPost(MultipartFile pd_contentImage) { // formData.append("pd_image", fileObj)의 key값 받아오기
		//System.out.println("파일업로드 컨트롤러 드러왔당");
		//System.out.println("파일 이름 : " + pd_image.getOriginalFilename());
		//System.out.println("파일 타입 : " + pd_image.getContentType());
		//System.out.println("파일 크기 : " + pd_image.getSize());

			// 파일이 이미지인지 체크해주는 코드
			File checkfile = new File(pd_contentImage.getOriginalFilename());
			System.out.println("checkfile"+ checkfile);
			System.out.println("pd_contentImage.getOriginalFilename()"+ pd_contentImage.getOriginalFilename());
			String type = null;
		
			try {
				type = Files.probeContentType(checkfile.toPath());
				System.out.println("MIME TYPE : "+ type);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(!type.startsWith("image")) { // 파일이 이미지가 아니면
				List<AttachImageVO> list = null; //list에 null값을 입력해줌
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST); // 상태가 400인 코드를 반환해줌
			}
		
		String uploadFolder = "C:\\onetrillion"; // 이미지 저장경로
		
		//날짜별로 저장해주는 코드 (일단 주석!)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		String datePath = str.replace("-", File.separator);
		
		File uploadPath = new File(uploadFolder); // 폴더 생성 
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		List<AttachImageVO> list = new ArrayList();
		
			// 이미지 정보 담는 객체 
			AttachImageVO vo = new AttachImageVO(); // 생성자로 초기화
			String uploadFileName = pd_contentImage.getOriginalFilename(); // 파일 이름 설정
			vo.setFileName(uploadFileName);
			vo.setUploadPath(datePath);
			
			String uuid = UUID.randomUUID().toString(); // uuid 적용 파일 이름 
			vo.setUuid(uuid);
			uploadFileName = uuid + "_" + uploadFileName; // 기존 파일명 + uuid 적용 파일 이름 
			
			File saveFile = new File(uploadPath, uploadFileName); // 파일 위치, 파일 이름을 합친 File 생성
			System.out.println("saveFile"+saveFile);
			
			// 최종 파일 저장 
			try {
				pd_contentImage.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			list.add(vo);

		// ResponseEntity를 이용해서 http 상태가 200일 때 http Body에 이미지정보가 담긴 List객체를 view페이지에 보내줌
		// ResponseEntity를 이용하면 상태코드와 http response 메시지를 조작할 수 있음
		ResponseEntity<List<AttachImageVO>> result = new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);
		return result;
	}
	
	
}
