/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class GUI {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    public void start() {
        LandingPanel landingPanel = new LandingPanel(FRAME_WIDTH, FRAME_HEIGHT);
        landingPanel.setVisible(true);
    }
}
