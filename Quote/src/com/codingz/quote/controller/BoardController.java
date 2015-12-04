package com.codingz.quote.controller;

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.quote.dao.BoardDAO;
import com.codingz.quote.dto.BoardWithStatusDto;
import com.codingz.quote.iservice.IBoardService;
import com.codingz.quote.iservice.ICategoriesService;
import com.codingz.quote.iservice.IFavorBoardService;
import com.codingz.quote.iservice.IStatusBoardService;
import com.codingz.quote.iservice.IUserService;
import com.codingz.quote.iservice.ICreditAuthorService;
import com.codingz.quote.model.Board;
import com.codingz.quote.model.BoardForm;
import com.codingz.quote.model.FavorBoard;
import com.codingz.quote.model.StatusBoard;
import com.codingz.quote.model.User;
import com.codingz.quote.model.Categories;
import com.codingz.quote.model.CreditAuthor;
import com.codingz.quote.service.Categorieservice;
import com.codingz.quote.service.FavorBoardService;
import com.codingz.quote.service.creditAuthorService;


@Controller
public class BoardController {

	@Autowired
	private IBoardService boardService;
	
	@Autowired
	private IFavorBoardService FavorBoardService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IStatusBoardService statusBoardService;
	
	@Autowired
	private ICategoriesService categoriesService;
	
	@Autowired
	private ICreditAuthorService creditAuthorService;

	@RequestMapping(value = "/board.html")
	public ModelAndView index() {

		try {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("board");

			List<Board> boardList = new ArrayList<Board>(boardService.findAll());
			Collections.reverse(boardList);					
			mav.addObject("boardList", boardList);
			List<FavorBoard> favBoardsList = new ArrayList<FavorBoard>(FavorBoardService.findAll());
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();			
			User user = userService.findByUsername(name);
			Long userId = user.getId();

			List<FavorBoard> favorBoardUserId = new ArrayList<FavorBoard>(FavorBoardService.findByUserId(userId));
			
			for(FavorBoard f:favorBoardUserId){
				System.out.println("name=="+f.getUser().getId());
			}

			
			List<BoardWithStatusDto> data = new ArrayList<>();
			
			for(Board board:boardList){
				
				BoardWithStatusDto row = new BoardWithStatusDto();
				
				row.setCategories(board.getCategories());
				row.setCreateDate(board.getCreateDate());
				row.setCreditAuthor(board.getCreditAuthor());
				row.setDetailBoard(board.getDetailPost());
				row.setUser(board.getUser());		
				row.setId(board.getId());
				row.setStatusFavor(false);
				
				for(FavorBoard favorBoard:favorBoardUserId){
					if(board.getId().equals(favorBoard.getBoard().getId())){
						
						row.setStatusFavor(favorBoard.getStatusFavor());	
						System.out.println("hey="+favorBoard.getStatusFavor());
						break;
					}else{
						row.setStatusFavor(false);
						System.out.println("board="+board.getId());
						System.out.println("favor="+favorBoard.getBoard().getId());
						
					}
				}
						
				data.add(row);
			}
			
				
			
			mav.addObject("boardDtoList", data);
			
			
			
			List<Categories> categoriesList = new ArrayList<Categories>(categoriesService.findAll());
			mav.addObject("categoriesList", categoriesList);
			
			
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("userId", user.getId());

			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "commentAns.html", method = RequestMethod.POST)
	public String save(Board board,@RequestParam String detailPost,
			@RequestParam(value = "user_id") Long userId,
			@RequestParam(value = "statusb_id") Long statusbId,
			@RequestParam(value = "creditAuthorId") Long creditAuthorId,
			@RequestParam(value = "categoriesId") Long categoriesId,
			@RequestParam String creditAuthorName) {
						
		try {
					
			User user = userService.findById(userId);
			board.setUser(user);
			StatusBoard statusBoard = statusBoardService.findById(statusbId);
			CreditAuthor creditAuthor = creditAuthorService.findById(creditAuthorId);
			Categories categories = categoriesService.findById(categoriesId);
			
			board.setCategories(categories);
			
			board.setStatusBoard(statusBoard);
			board.setDetailPost(detailPost);
			board.setCreateDate(Calendar.getInstance());
			
			
			creditAuthor.setCreditAuthorName(creditAuthorName);
			creditAuthorService.save(creditAuthor);
			
			CreditAuthor creditN = creditAuthorService.findByCreditAuthorName(creditAuthorName);
			board.setCreditAuthor(creditN);
			boardService.save(board);

			return "redirect:/board.html";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}
	
	
	@RequestMapping(value = "convertTosave.html")
	public String convertToSave(Board board,@RequestParam("text1") String text1,
			@RequestParam("text2") String text2,
			@RequestParam("text3") String text3,
			@RequestParam("userId") Long userId,
			@RequestParam("statusb") Long statusbId,
			@RequestParam("categoriesId") Long categoriesId,
			@RequestParam("creditId") Long creditId) {
						
		try {
			String detailPost = text1+" "+text2+" "+text3;		
			User user = userService.findById(userId);
			board.setUser(user);
			StatusBoard statusBoard = statusBoardService.findById(statusbId);
			Categories categories = categoriesService.findById(categoriesId);
			CreditAuthor creditAuthor = creditAuthorService.findById(creditId);
			
			board.setCategories(categories);			
			board.setStatusBoard(statusBoard);
			board.setDetailPost(detailPost);
			board.setCreateDate(Calendar.getInstance());
			board.setCreditAuthor(creditAuthor);
			boardService.save(board);

			return "redirect:/board.html";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}
	
	@RequestMapping(value="/myQuote.html")
	public ModelAndView myQuote(){
				
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("myQuote");
			List<Board> boradList = new ArrayList<Board>(boardService.findAll());
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("useId", user.getId());		
			mav.addObject("boardList", boradList);
			return mav;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@RequestMapping(value = "/editMyQuote.html", method = RequestMethod.POST)
	public String editMyQuote(@RequestParam String detailPost,
			@RequestParam(value = "user_id") Long userId,
			@RequestParam Long categoriesId,
			@RequestParam Long creditAuthorId,
			@RequestParam Long statusBoardId,
			@ModelAttribute BoardForm boardForm){
		try {
			Board board = boardService.findById(boardForm.getId());
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd",java.util.Locale.US);
			Date createDate=null;
			
			try {
				createDate = df.parse(boardForm.getCreateDate());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Calendar createD = board.getCreateDate();
			
			StatusBoard statusBoard = statusBoardService.findById(statusBoardId);
			board.setStatusBoard(statusBoard);
			CreditAuthor creditAuthor = creditAuthorService.findById(creditAuthorId);
			board.setCreditAuthor(creditAuthor);
			Categories categories = categoriesService.findById(categoriesId);
			board.setCategories(categories);
			User user = userService.findById(userId);
			board.setUser(user);
			board.setDetailPost(detailPost);
			
			boardService.update(board);
			return "redirect:/myQuote.html";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/editMyQuoteFromBoard.html", method = RequestMethod.POST)
	public String editMyQuoteFromBoard(@RequestParam String detailPost,
			@RequestParam(value = "user_id") Long userId,
			@RequestParam Long categoriesId,
			@RequestParam Long creditAuthorId,
			@RequestParam Long statusBoardId,
			@ModelAttribute BoardForm boardForm){
		try {
			Board board = boardService.findById(boardForm.getId());
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date createDate=null;
			
			try {
				createDate = df.parse(boardForm.getCreateDate());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			StatusBoard statusBoard = statusBoardService.findById(statusBoardId);
			board.setStatusBoard(statusBoard);
			CreditAuthor creditAuthor = creditAuthorService.findById(creditAuthorId);
			board.setCreditAuthor(creditAuthor);
			Categories categories = categoriesService.findById(categoriesId);
			board.setCategories(categories);
			User user = userService.findById(userId);
			board.setUser(user);
			board.setDetailPost(detailPost);
			
			boardService.update(board);
			return "redirect:/board.html";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/deleteQuote.html",method=RequestMethod.POST)
	public String deleteQute(@RequestParam Long id){
		try {
			Board board = boardService.findById(id);
			boardService.delete(board);
			return "success";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/afterConvert.html")
	public ModelAndView afterConver(Board board) {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("afterConvert");
			Board boardetail = boardService.findById(board.getId());
			mav.addObject("board", board);
			mav.addObject("boardDetail", boardetail);
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userName", user.getUsername());
			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/afterMy.html")
	public ModelAndView afterMy(Board board) {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("afterConvert");
			Board boardetail = boardService.findById(board.getId());
			mav.addObject("board", board);
			mav.addObject("boardDetail", boardetail);
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userName", user.getUsername());
			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//@RequestMapping(value = "/quoteOfUser.html")
	public ModelAndView userQuote(Board board) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("quoteOfUser");
			
			Board userIdFromBoard = boardService.findById(board.getId());
			
			mav.addObject("userIdformboard", board);
			mav.addObject("userIdFormQuote",userIdFromBoard);

			List<Board> boardList = new ArrayList<Board>(boardService.findAll());
			mav.addObject("boardList", boardList);
			
			List<Categories> categoriesList = new ArrayList<Categories>(categoriesService.findAll());
			mav.addObject("categoriesList", categoriesList);
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			
			
			User user = userService.findByUsername(name);
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("userId", user.getId());

			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/quoteOfUser.html")
	public ModelAndView quoteOfuser(Board board) {

		try {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("quoteOfUser");
			
			Board userIdFromBoard = boardService.findById(board.getId());
			
			mav.addObject("userIdformboard", board);
			mav.addObject("userIdFormQuote",userIdFromBoard);

			List<Board> boardList = new ArrayList<Board>(boardService.findAll());
			Collections.reverse(boardList);					
			mav.addObject("boardList", boardList);
			List<FavorBoard> favBoardsList = new ArrayList<FavorBoard>(FavorBoardService.findAll());
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();			
			User user = userService.findByUsername(name);
			Long userId = user.getId();

			List<FavorBoard> favorBoardUserId = new ArrayList<FavorBoard>(FavorBoardService.findByUserId(userId));
			
			for(FavorBoard f:favorBoardUserId){
				System.out.println("name=="+f.getUser().getId());
			}

			
			List<BoardWithStatusDto> data = new ArrayList<>();
			
			for(Board board1:boardList){
				
				BoardWithStatusDto row = new BoardWithStatusDto();
				
				row.setCategories(board1.getCategories());
				row.setCreateDate(board1.getCreateDate());
				row.setCreditAuthor(board1.getCreditAuthor());
				row.setDetailBoard(board1.getDetailPost());
				row.setUser(board1.getUser());		
				row.setId(board1.getId());
				row.setStatusFavor(false);
				
				for(FavorBoard favorBoard:favorBoardUserId){
					if(board1.getId().equals(favorBoard.getBoard().getId())){
						
						row.setStatusFavor(favorBoard.getStatusFavor());	
						System.out.println("hey="+favorBoard.getStatusFavor());
						break;
					}else{
						row.setStatusFavor(false);
						System.out.println("board="+board1.getId());
						System.out.println("favor="+favorBoard.getBoard().getId());
						
					}
				}
						
				data.add(row);
			}
			
				
			
			mav.addObject("boardDtoList", data);
			
			
			
			List<Categories> categoriesList = new ArrayList<Categories>(categoriesService.findAll());
			mav.addObject("categoriesList", categoriesList);
			
			
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("userId", user.getId());

			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "categoriesOfQuotes.html")
	public ModelAndView categoriesofQuote(Board board) {

		try {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("categoriesOfQuotes");
			
			Board userIdFromBoard = boardService.findById(board.getId());
			
			mav.addObject("categoriesOfquote", board);
			mav.addObject("userIdFormQuote",userIdFromBoard);

			List<Board> boardList = new ArrayList<Board>(boardService.findAll());
			Collections.reverse(boardList);					
			mav.addObject("boardList", boardList);
			List<FavorBoard> favBoardsList = new ArrayList<FavorBoard>(FavorBoardService.findAll());
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();			
			User user = userService.findByUsername(name);
			Long userId = user.getId();

			List<FavorBoard> favorBoardUserId = new ArrayList<FavorBoard>(FavorBoardService.findByUserId(userId));
			
			for(FavorBoard f:favorBoardUserId){
				System.out.println("name=="+f.getUser().getId());
			}

			
			List<BoardWithStatusDto> data = new ArrayList<>();
			
			for(Board board1:boardList){
				
				BoardWithStatusDto row = new BoardWithStatusDto();
				
				row.setCategories(board1.getCategories());
				row.setCreateDate(board1.getCreateDate());
				row.setCreditAuthor(board1.getCreditAuthor());
				row.setDetailBoard(board1.getDetailPost());
				row.setUser(board1.getUser());		
				row.setId(board1.getId());
				row.setStatusFavor(false);
				
				for(FavorBoard favorBoard:favorBoardUserId){
					if(board1.getId().equals(favorBoard.getBoard().getId())){
						
						row.setStatusFavor(favorBoard.getStatusFavor());	
						System.out.println("hey="+favorBoard.getStatusFavor());
						break;
					}else{
						row.setStatusFavor(false);
						System.out.println("board="+board1.getId());
						System.out.println("favor="+favorBoard.getBoard().getId());
						
					}
				}
						
				data.add(row);
			}
			
				
			
			mav.addObject("boardDtoList", data);
			
			
			
			List<Categories> categoriesList = new ArrayList<Categories>(categoriesService.findAll());
			mav.addObject("categoriesList", categoriesList);
			
			
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("userId", user.getId());

			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//@RequestMapping(value = "categoriesOfQuotes.html")
	public ModelAndView categoriesOfQuote(Board board) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("categoriesOfQuotes");
			
			Board userIdFromBoard = boardService.findById(board.getId());
			
			mav.addObject("categoriesOfquote", board);
			mav.addObject("userIdFormQuote",userIdFromBoard);

			List<Board> boardList = new ArrayList<Board>(boardService.findAll());
			mav.addObject("boardList", boardList);
			
			List<Categories> categoriesList = new ArrayList<Categories>(categoriesService.findAll());
			mav.addObject("categoriesList", categoriesList);
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			System.out.println("Youuu== " + name);
			
			User user = userService.findByUsername(name);
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("userId", user.getId());

			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
