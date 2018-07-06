package codesquad.web;

import codesquad.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class QuestionController {
    private int id = 0;
    Map<Integer, Question> questions = new HashMap<>();

    @PostMapping("/questions")
    public String create(Question question) {
        question.setId(++id);
        questions.put(question.getId(), question);
        return "redirect:/";
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("questions", questions.values());
        return "/index";
    }

    @GetMapping("/questions/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("question", questions.get(id));
        return "/qna/show";
    }
}
