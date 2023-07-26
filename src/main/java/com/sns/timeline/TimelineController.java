package com.sns.timeline;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sns.timeline.bo.TimelineBO;
import com.sns.timeline.domain.CardView;

@Controller
@RequestMapping("/timeline")
public class TimelineController {

	@Autowired
	private TimelineBO timelineBO;
	
	@GetMapping("/timeline_view")
	public String timelineView(Model model, HttpSession session) {
		Integer userId = (Integer)session.getAttribute("userId");
		
		List<CardView> cardList = timelineBO.generateCardViewList(userId);
		model.addAttribute("cardList", cardList);
		model.addAttribute("view", "timeline/timeline");
		return "template/layout";
	}
}
