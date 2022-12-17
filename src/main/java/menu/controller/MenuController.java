package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        getInputs();
    }

    public void getInputs() {
        List<String> coachNames = getCoachName();
        List<Coach> coaches = getCoachCannotEatMenus(coachNames);
    }

    public List<String> getCoachName() {
        try {
            return inputView.getCoachName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachName();
        }
    }

    public List<Coach> getCoachCannotEatMenus(List<String> coachNames) {
        try {
            return inputView.getCoachCannotEatMenus(coachNames);
        }  catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachCannotEatMenus(coachNames);
        }
    }
}
