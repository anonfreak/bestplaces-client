package de.bestplaces.view.dashboard.components;


import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import de.bestplaces.model.FullPlace;
import de.bestplaces.model.Visit;


/**
 * Created by franzi on 02.06.2017.
 */
public class VisitTile extends Panel{

    private Visit visit;
    private FullPlace fullPlace;
    private HorizontalSplitPanel visitInfo;
    private HorizontalLayout starLayout;
    private ImagePanel imagePanel;

    private Label placeName;
    private Label duration;

    public VisitTile(Visit visit, FullPlace fullPlace)
    {
        this.visit = visit;
        this.fullPlace = fullPlace;

        HorizontalLayout layout = new HorizontalLayout();

        layout.addComponent(getVisitInfo());
        layout.addComponent(getStarLayout());
        layout.addComponent(getImagePanel());

        setContent(layout);
    }

    public HorizontalSplitPanel getVisitInfo()
    {
        if(visitInfo == null)
        {
            visitInfo = new HorizontalSplitPanel();
            visitInfo.setFirstComponent(getPlaceName());
            visitInfo.setSecondComponent(getDuration());
        }
        return visitInfo;
    }

    public Label getPlaceName() {
        if(placeName == null)
        {
            placeName = new Label(fullPlace.getName());
        }
        return placeName;
    }

    public Label getDuration() {
        if(duration == null)
        {
            duration = new Label("Sorry, not available at the moment");
        }
        return duration;
    }

    public HorizontalLayout getStarLayout()
    {
        if(starLayout==null)
        {
            Label star;
            starLayout = new HorizontalLayout();
            for (int i = 0; i < fullPlace.getAverageStar() ; i++) {

                star = new Label(FontAwesome.STAR.getHtml() + "");
                star.setContentMode(ContentMode.HTML);
                starLayout.addComponent(star);
            }
        }
        return starLayout;
    }

    public ImagePanel getImagePanel()
    {
        if (imagePanel == null)
        {
            imagePanel = new ImagePanel(fullPlace.getPictures(), true);
        }
        return imagePanel;
    }
}
