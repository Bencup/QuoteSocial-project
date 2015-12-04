package com.codingz.quote.controller;

import java.awt.Color;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.quote.iservice.IUserService;
import com.codingz.quote.model.User;


@Controller
public class ConvertController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/convert.html")
	public ModelAndView convert() {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("convert");
			
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

	@RequestMapping(value = "/convert-ans.html")
	public String convertImage(@RequestParam String textConvert) {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("convert" + textConvert);
			
			String [] txt = new String[10];
			for(int i=0 ;i<textConvert.length();i++){
			}
			String [] split = textConvert.split("\n");
			
			

			/*BufferedImage img = new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = img.createGraphics();
	        g2d.setColor(Color.black);
	        Font font = new Font("quark", Font.PLAIN, 48);
	        g2d.setFont(font);
	        FontMetrics fm = g2d.getFontMetrics();
	        
	        int width = fm.stringWidth(textConvert);
	        int height = fm.getHeight();
	        g2d.dispose();
            
	        img = new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
	        g2d.setColor(Color.red);
			g2d.fillRect(0, 0, 500, 300);
	        g2d = img.createGraphics();
	        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
	        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
	        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	        g2d.setFont(font);
	        fm = g2d.getFontMetrics();*/
			
			BufferedImage bufferedImage = new BufferedImage(500, 300,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedImage.createGraphics();

			// set black ground
			g2d.setColor(Color.black);
			g2d.fillRect(0, 0, 500, 300);
			g2d.setColor(Color.white);
			g2d.setFont(new Font("quark", Font.PLAIN, 48));
			g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
			g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	        
	        	        
	        for(int i=0;i<split.length;i++){
	        	
	        	g2d.drawString(split[i],0,(i+1)*50);
	        }
	               
	        
	       //g2d.dispose();
			
				       
			ImageIO.write(bufferedImage, "jpg", new File(
					"C:/Users/ITeam5/Desktop/hekki.PNG"));

			return "convert";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "error";
	}
	

		
	@RequestMapping(value="/convertButton.html")
	public String convertButton(@RequestParam String detailPost){
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("convertButton");

			BufferedImage bufferedImage = new BufferedImage(500, 300,
					BufferedImage.TYPE_INT_RGB);
			Graphics graphics = bufferedImage.getGraphics();

			// set black ground
			graphics.setColor(Color.white);
			graphics.fillRect(0, 0, 500, 300);
			graphics.setColor(Color.black);
			graphics.setFont(new Font("quark", Font.BOLD, 30));
			// graphics.drawString(key, 10, 25);
			drawCenteredString(detailPost, 500, 300, graphics);

			ImageIO.write(bufferedImage, "jpg", new File(
					"C:/Users/ITeam5/Desktop/testformButton.PNG"));
			System.out.println("Image has been Create");
			mav.addObject("imageConvert", bufferedImage);

			return "redirect:/board.html";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void drawCenteredString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s)) / 2;
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(s, x, y);
		
	}
	
	@RequestMapping(value="/convertMyQuote.html")
	public String convertMyQuote(@RequestParam String detailPost){
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("convertButton");

			BufferedImage bufferedImage = new BufferedImage(500, 300,
					BufferedImage.TYPE_INT_RGB);
			Graphics graphics = bufferedImage.getGraphics();

			// set black ground
			graphics.setColor(Color.white);
			graphics.fillRect(0, 0, 500, 300);
			graphics.setColor(Color.black);
			graphics.setFont(new Font("quark", Font.BOLD, 30));
			// graphics.drawString(key, 10, 25);
			drawCenteredString(detailPost, 500, 300, graphics);
			

			ImageIO.write(bufferedImage, "jpg", new File(
					"C:/Users/ITeam5/Desktop/testformButton.PNG"));
			System.out.println("Image has been Create");
			mav.addObject("imageConvert", bufferedImage);

			return "redirect:/myQuote.html";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="/convertFavor.html")
	public String convertFavor(@RequestParam String detailPost){
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("convertButton");

			BufferedImage bufferedImage = new BufferedImage(500, 300,
					BufferedImage.TYPE_INT_RGB);
			Graphics graphics = bufferedImage.getGraphics();

			// set black ground
			graphics.setColor(Color.white);
			graphics.fillRect(0, 0, 500, 300);
			graphics.setColor(Color.black);
			graphics.setFont(new Font("quark", Font.BOLD, 30));
			// graphics.drawString(key, 10, 25);
			drawCenteredString(detailPost, 500, 300, graphics);

			ImageIO.write(bufferedImage, "jpg", new File(
					"C:/Users/ITeam5/Desktop/testformButton.PNG"));
			System.out.println("Image has been Create");
			mav.addObject("imageConvert", bufferedImage);

			return "redirect:/favorBoard.html";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
