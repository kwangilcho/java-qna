package codesquad.web;

import codesquad.domain.Question;
import codesquad.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class QuestionController {
    private final String QUESTION_ROOT_PATH = "/questions";
    private long questionId = 0;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping(QUESTION_ROOT_PATH)
    public String create(Question question) {
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("questions",questionRepository.findAll());
        return "/index";
    }

    @GetMapping(QUESTION_ROOT_PATH + "/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        return "/qna/show";
    }

    @GetMapping(QUESTION_ROOT_PATH + "/{id}/form")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        return "/qna/updateForm";
    }

    @PostMapping(QUESTION_ROOT_PATH + "/{id}")
    public String update(@PathVariable Long id, Question question) {
        Question questionOrigin = questionRepository.findById(id).get();
        questionOrigin.update(question);
        questionRepository.save(questionOrigin);
        return "redirect:/";
    }

    @DeleteMapping(QUESTION_ROOT_PATH + "/{id}")
    public String delete(@PathVariable Long id) {
        Question questionOrigin = questionRepository.findById(id).get();
        questionRepository.delete(questionOrigin);
        return "redirect:/";
    }
}
