package com.codingz.quote.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.quote.iservice.IBoardService;
import com.codingz.quote.iservice.IFavorBoardService;
import com.codingz.quote.iservice.IUserService;
import com.codingz.quote.model.Board;
import com.codingz.quote.model.FavorBoard;
import com.codingz.quote.model.User;
import com.codingz.quote.service.BoardService;

@Controller
public class FavorBoardController {

	@Autowired
	private IFavorBoardService favorBoardService;
	
	@Autowired
	private IBoardService boardService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/favorBoard.html")
	public ModelAndView index() {
		try {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("favorBoard");

			List<FavorBoard> favorBoardList = new ArrayList<FavorBoard>(
					favorBoardService.findAll());
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("useId", user.getId());	
			mav.addObject("favorBoardList", favorBoardList);

			return mav;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/favoriteButton.html", method = RequestMethod.POST)
	public String save(FavorBoard favorBoard,@RequestParam Long boardId,
			@RequestParam Long userId) {

		try {
			Board board = boardService.findById(boardId);
			User user = userService.findById(userId);
			favorBoard.setUser(user);		
			favorBoard.setBoard(board);
			favorBoardService.save(favorBoard);
			return "redirect:/favorBoard.html";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}
	
	@RequestMapping(value = "/favoriteQuote.html")
	public String savefavor(FavorBoard favorBoard,@RequestParam("quoteId") Long id,
			@RequestParam("userId") Long userId) {
		try {
			Board board = boardService.findById(id);
			User user = userService.findById(userId);
			favorBoard.setUser(user);		
			favorBoard.setBoard(board);
			favorBoardService.save(favorBoard);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/unFavorite.html")
	public String unFavorite(FavorBoard favorBoard,@RequestParam("quoteId") Long quoteId,
			@RequestParam("userId") Long userId) {
		try {
			//FavorBoard favorboad = favorBoardService.findById(userId);
			Board board = boardService.findById(quoteId);
			User user = userService.findById(userId);
			
			List<FavorBoard> favorBoardList = new ArrayList<FavorBoard>(favorBoardService.findCheckByuserIdAndQuoteId(userId, quoteId));
			
		   for (FavorBoard f : favorBoardList) {
			System.out.println("test=="+f.getBoard().getDetailPost());
			System.out.println("test=="+f.getUser().getUsername());
		   	}
		   System.out.println("tetsss="+favorBoardList);
		   
		   Boolean en = true;
		   
		   if(favorBoardList.size()!=0){
			   	
			   if(favorBoardList.get(0).getStatusFavor() == true){
				   Long favorId = favorBoardList.get(0).getId();
				   FavorBoard faBoard = favorBoardService.findById(favorId);				   			   
				   faBoard.setStatusFavor(false);
				   favorBoardService.update(faBoard);
			   		System.out.println("it's not nuull1");
			   		return "success";
			   	}else{
			   		Long favorId = favorBoardList.get(0).getId();
					   FavorBoard faBoard = favorBoardService.findById(favorId);				   			   
					   faBoard.setStatusFavor(true);
					   favorBoardService.update(faBoard);
			   		
					System.out.println("it's not nuull2");
					return "success";
			   	}
			   
		   }else {
			   favorBoard.setUser(user);
			   favorBoard.setBoard(board);
			   favorBoard.setStatusFavor(true);
			   favorBoardService.save(favorBoard);
			   System.out.println("it's nuull");
			   return "success";
			   
		}
		   
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		
	}
	
	@RequestMapping(value="/deleteFavor.html")
	public String deleteFavor(@RequestParam Long id){
		try {
			FavorBoard favorBoard = favorBoardService.findById(id);
			favorBoardService.delete(favorBoard);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/afterFavor.html")
	public ModelAndView afterConver(FavorBoard favorBoard) {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("afterFavor");
			FavorBoard favor = favorBoardService.findById(favorBoard.getId());
			
			mav.addObject("favorBoard", favorBoard);
			mav.addObject("favor", favor);
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
}
