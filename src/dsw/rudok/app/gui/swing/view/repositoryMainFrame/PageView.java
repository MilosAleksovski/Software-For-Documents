package dsw.rudok.app.gui.swing.view.repositoryMainFrame;

import dsw.rudok.app.gui.swing.observerMainPanel.Publisher;
import dsw.rudok.app.gui.swing.observerMainPanel.Subscriber;
import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.repository.state.stateRepo.MoveState;
import dsw.rudok.app.repository.updateEvent.UpdateEvent;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.Iterator;

public class PageView extends JPanel implements Subscriber, Serializable {
    private Page page;
    private JLabel ime;
    private static long serialVersionUID = 4L;
    transient public static Graphics2D graphics2D;

    public PageView(Page page){
         this.page = page;
         page.addSubscriber(this);
         this.page.getpModel().addUpdateListener(this);
         napraviStranicu();

    }

    public void napraviStranicu(){
        ime = new JLabel(page.getName());
        DiagramController diaCont=new DiagramController();
        this.addMouseListener(diaCont);
        this.addMouseMotionListener(diaCont);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        this.setSize(400,400);
        this.add(ime);
    }
    private class DiagramController extends MouseAdapter implements MouseMotionListener , Serializable {
        public void mousePressed(MouseEvent e) { page.getStateManager().getCurrentState().mousePressed(e); }
        public void mouseReleased(MouseEvent e) {
            page.getStateManager().getCurrentState().mouseReleased(e);
        }
        public void mouseDragged(MouseEvent e ){
            page.getStateManager().getCurrentState().mouseDragged(e);
        }
    }


    @Override
    public void updateDodavanje(Publisher publisher) {

    }

    @Override
    public void updateBrisanje(Publisher publisher) {

    }

    @Override
    public void updateIme(Publisher publisher) {
        ime.setText(page.getName());

    }

    @Override
    public void updateDoubleCLick(Publisher publisher) {

    }

    @Override
    public void updatePerformed(UpdateEvent e) {

        repaint();
    }



    protected void paintComponent(Graphics g) {


        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        graphics2D = g2;


        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));

        Iterator<Slot> it = page.getpModel().getDeviceIterator();
        while(it.hasNext()){

            Slot d =  it.next();
            ElementPainter painter =  d.getElementPainter();
            painter.paint(g2, d);

        }
    }

    public Page getPage() {
        return page;
    }

}
