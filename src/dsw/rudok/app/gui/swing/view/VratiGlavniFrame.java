package dsw.rudok.app.gui.swing.view;

public class VratiGlavniFrame implements RuView {

    private GlavniFrame glavniFrame ;

    public VratiGlavniFrame(){
        glavniFrame = GlavniFrame.getInstance();
    }

    @Override
    public GlavniFrame vratiGlavniFrame() {
        return glavniFrame;
    }
}
