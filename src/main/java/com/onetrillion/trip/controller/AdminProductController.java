package com.onetrillion.trip.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.onetrillion.trip.admin.BoardUpFile;
import com.onetrillion.trip.board.BoardCriteria;
import com.onetrillion.trip.board.BoardDTO;
import com.onetrillion.trip.board.PageMakerDTO;
import com.onetrillion.trip.board.impl.BoardService;

@Controller
@RequestMapping(value = "/adminProduct")
public class AdminProductController {

	private static final Logger log = LoggerFactory.getLogger(AdminProductController.class);

	@Autowired
	public BoardService service;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String ListAll(Model model, BoardCriteria cri) {
		List<BoardDTO> pdList = service.BoardPaging(cri);
		model.addAttribute("pdList", pdList);
		int total = service.BoardCount(cri);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);

		model.addAttribute("pageMaker", pageMake);
		
		System.out.println(pdList.toString());
	
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
	@RequestMapping(value = "/mini.do", method = RequestMethod.GET)
	public String mini(Model model) {
		List<BoardDTO> pdList = service.selectAll();
		model.addAttribute("pdList", pdList);
		return "adminProduct/adminPdMini";
	}

	
	  // 관리자 상품 입력 완료
	  
	 @RequestMapping(value = "/input.do", method = RequestMethod.POST)
	 public String insertPost(BoardDTO dto) throws IllegalStateException, IOException {		 
// 메인 이미지 파일 업로드 처리--------------------------------------------------------------------------
			String pd_image=null;
			MultipartFile uploadFile = dto.getUploadFile();
			if (!uploadFile.isEmpty()) {
				String originalFileName = uploadFile.getOriginalFilename();
				String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
				UUID uuid = UUID.randomUUID();	//UUID 구하기
				pd_image=uuid+"."+ext;
				uploadFile.transferTo(new File( "D:\\OneTrillion-final\\OneTrillion-Final\\src\\main\\webapp\\resources\\upload\\" + pd_image));
			}
			dto.setPd_image(pd_image);
			
			String pd_contentImage1=null;
			MultipartFile uploadFile1 = dto.getUploadFile1();
			if (!uploadFile1.isEmpty()) {
				String originalFileName1 = uploadFile1.getOriginalFilename();
				String ext1 = FilenameUtils.getExtension(originalFileName1);	//확장자 구하기
				UUID uuid1 = UUID.randomUUID();	//UUID 구하기
				pd_contentImage1=uuid1+"."+ext1;
				uploadFile1.transferTo(new File( "D:\\OneTrillion-final\\OneTrillion-Final\\src\\main\\webapp\\resources\\upload\\" + pd_contentImage1));
			}
			dto.setPd_contentImage1(pd_contentImage1);
			
			String pd_contentImage2=null;
			MultipartFile uploadFile2 = dto.getUploadFile2();
			if (!uploadFile2.isEmpty()) {
				String originalFileName2 = uploadFile2.getOriginalFilename();
				String ext2 = FilenameUtils.getExtension(originalFileName2);	//확장자 구하기
				UUID uuid2 = UUID.randomUUID();	//UUID 구하기
				pd_contentImage2=uuid2+"."+ext2;
				uploadFile2.transferTo(new File( "D:\\OneTrillion-final\\OneTrillion-Final\\src\\main\\webapp\\resources\\upload\\" + pd_contentImage2));
			}
			dto.setPd_contentImage2(pd_contentImage2);
			
			String pd_contentImage3=null;
			MultipartFile uploadFile3 = dto.getUploadFile3();
			if (!uploadFile3.isEmpty()) {
				String originalFileName3 = uploadFile3.getOriginalFilename();
				String ext3 = FilenameUtils.getExtension(originalFileName3);	//확장자 구하기
				UUID uuid3 = UUID.randomUUID();	//UUID 구하기
				pd_contentImage3=uuid3+"."+ext3;
				uploadFile3.transferTo(new File( "D:\\OneTrillion-final\\OneTrillion-Final\\src\\main\\webapp\\resources\\upload\\" + pd_contentImage3));
			}
			dto.setPd_contentImage3(pd_contentImage3);
			
			String pd_contentImage4=null;
			MultipartFile uploadFile4 = dto.getUploadFile4();
			if (!uploadFile4.isEmpty()) {
				String originalFileName4 = uploadFile4.getOriginalFilename();
				String ext4 = FilenameUtils.getExtension(originalFileName4);	//확장자 구하기
				UUID uuid4 = UUID.randomUUID();	//UUID 구하기
				pd_contentImage4=uuid4+"."+ext4;
				uploadFile4.transferTo(new File( "D:\\OneTrillion-final\\OneTrillion-Final\\src\\main\\webapp\\resources\\upload\\" + pd_contentImage4));
			}
			dto.setPd_contentImage4(pd_contentImage4);
			
			String pd_contentImage5=null;
			MultipartFile uploadFile5 = dto.getUploadFile5();
			if (!uploadFile5.isEmpty()) {
				String originalFileName5 = uploadFile5.getOriginalFilename();
				String ext5 = FilenameUtils.getExtension(originalFileName5);	//확장자 구하기
				UUID uuid5 = UUID.randomUUID();	//UUID 구하기
				pd_contentImage5=uuid5+"."+ext5;
				uploadFile5.transferTo(new File( "D:\\OneTrillion-final\\OneTrillion-Final\\src\\main\\webapp\\resources\\upload\\" + pd_contentImage5));
			}
			dto.setPd_contentImage5(pd_contentImage5);
			
			service.insert(dto);
			return "redirect:/adminProduct/list.do"; 
//파일 업로드 처리--------------------------------------------------------------------------	 
			
// pd_contentImage1 이미지 파일 업로드 처리--------------------------------------------------------------------------
		/*	String pd_contentImage1=null;
			MultipartFile uploadFile = dto.getUploadFile();
			if (!uploadFile.isEmpty()) {
				String originalFileName = uploadFile.getOriginalFilename();
				String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
				UUID uuid = UUID.randomUUID();	//UUID 구하기
				pd_image=uuid+"."+ext;
				uploadFile.transferTo(new File( "D:\\OneTrillion-final\\OneTrillion-Final\\src\\main\\webapp\\resources\\upload\\" + pd_image));
			}
			dto.setPd_image(pd_image);
			System.out.println(pd_image);
			service.insert(dto); 
			return "redirect:/adminProduct/list.do"; */
//파일 업로드 처리--------------------------------------------------------------------------	 
		 
	 }

	// 관리자 상품 입력 페이지 이동
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String insertGet() {
		return "adminProduct/adminPdInput";
	}



}