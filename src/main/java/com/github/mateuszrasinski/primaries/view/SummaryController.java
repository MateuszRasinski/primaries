package com.github.mateuszrasinski.primaries.view;

import com.github.mateuszrasinski.primaries.application.VoteService;
import com.github.mateuszrasinski.primaries.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/summary")
public class SummaryController {
    private final VoteService voteService;

    @Autowired
    public SummaryController(VoteService voteService) {
        this.voteService = voteService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String summary(Model model) {
        Summary summary = voteService.summary();
        model.addAttribute("summary", summary);
        return "summary";
    }
}
