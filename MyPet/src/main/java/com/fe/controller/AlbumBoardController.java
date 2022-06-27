package com.fe.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fe.service.AlbumBoardService;
import com.fe.vo.AlbumBoardVO;

@Controller
@RequestMapping("/albumboard/*")
public class AlbumBoardController {
	
	// 의존객체
	@Autowired
	AlbumBoardService service;
	
	
	// 글쓰기  get
	@GetMapping("/writeView")
	public void writeView() throws Exception{
		
	}
	
	// 글쓰기 post
	@PostMapping("/write")
	public String write(AlbumBoardVO vo, MultipartHttpServletRequest mpRequest) throws Exception{
		
		service.write(vo, mpRequest);
		
		return "redirect:/albumboard/list";
	}
	
	// 앨범 리스트
	@GetMapping("/list")
	public String list(Model model) throws Exception{

		byte[] fileByte = null;
		
		List<String> supplierNames1 = new ArrayList<String>();
		
		model.addAttribute("list", service.list());
	   
		for(int i=0; i<service.list().size(); i++) {
			
		List<Map<String,Object>> fileList = service.selectFileList(service.list().get(i).getAno());
		
		String storedFileName = fileList.get(0).get("STORED_FILE_NAME").toString();
		
		fileByte = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\mp\\file\\"+ storedFileName));
	
		String fileImg = new String(Base64.getEncoder().encode(fileByte));
		 
		supplierNames1.add(fileImg);
		 
		}
	
		model.addAttribute("fileImag",supplierNames1);
		
		
		return "albumboard/list";
		
	}
	
	// 게시판 수정뷰
	@GetMapping("/updateView")
	public String updateView(AlbumBoardVO vo, Model model) throws Exception{
		
		model.addAttribute("update", service.read(vo.getAno()));
		
		List<Map<String,Object>> fileList = service.selectFileList(vo.getAno());

		// 수정 조회
		
		// 저장된 사진 이름 가져오기
		String storedFileName = fileList.get(0).get("STORED_FILE_NAME").toString();
		
		// 사진 -> 바이트파일
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\mp\\file\\"+ storedFileName));

		// 이미지 바이트 파일 -> 인코더
		String fileImg = new String(Base64.getEncoder().encode(fileByte));

	    model.addAttribute("fileImg",fileImg);
		model.addAttribute("read", service.read(vo.getAno()));
		model.addAttribute("file",fileList);	
		
		return "albumboard/updateView";
	}
	
	// 게시판 수정
	@PostMapping("/update")
	public String update(AlbumBoardVO vo) throws Exception{
		
		service.update(vo);
		
		return "redirect:/albumboard/list";
	}

	// 게시판 삭제
	@PostMapping("/delete")
	public String delete(AlbumBoardVO vo) throws Exception{
		service.delete(vo.getAno());
		return "redirect:/albumboard/list";
	}
	
	@GetMapping("/readView")
	public String read(AlbumBoardVO vo, Model model) throws Exception{

		List<Map<String,Object>> fileList = service.selectFileList(vo.getAno());

		// 조회
		
		// 저장된 사진 이름 가져오기
		String storedFileName = fileList.get(0).get("STORED_FILE_NAME").toString();
		// 사진 -> 바이트파일
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\mp\\file\\"+ storedFileName));
	    // 이미지 바이트 파일 -> 인코더
		String fileImg = new String(Base64.getEncoder().encode(fileByte));

	    model.addAttribute("fileImg",fileImg);
		model.addAttribute("read", service.read(vo.getAno()));
		model.addAttribute("file",fileList);	
		
		return "albumboard/readView";
	}
	
	
	@RequestMapping(value="/fileDown")
	public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
		
		Map<String, Object> resultMap = service.selectFileInfo(map);
		String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
		String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
		
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\mp\\file\\"+storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
	

	
}
