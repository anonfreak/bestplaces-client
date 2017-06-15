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
    private VerticalSplitPanel visitInfo;
    private VerticalSplitPanel placeNameAndStars;
    private HorizontalLayout starLayout;
    private ImagePanel imagePanel;

    private Label placeName;
    private Label duration;

    public VisitTile(Visit visit, FullPlace fullPlace)
    {
        this.visit = visit;
        this.fullPlace = fullPlace;

        HorizontalSplitPanel layout = new HorizontalSplitPanel();
        layout.setWidth("597px");
        layout.setHeight("150px");
        layout.setSplitPosition(70);

        layout.setFirstComponent(getVisitInfo());
        layout.setSecondComponent(getImagePanel());

        setContent(layout);
    }

    public VerticalSplitPanel getVisitInfo()
    {
        if(visitInfo == null)
        {
            visitInfo = new VerticalSplitPanel();
            visitInfo.addComponent(getPlaceNameAndStars());
            visitInfo.addComponent(getDuration());
            visitInfo.setSplitPosition(66);
            visitInfo.setLocked(true);
            visitInfo.setSizeFull();
        }
        return visitInfo;
    }

    public VerticalSplitPanel getPlaceNameAndStars() {
        if(placeNameAndStars == null)
        {
            placeNameAndStars = new VerticalSplitPanel();
            placeNameAndStars.addComponent(getPlaceName());
            placeNameAndStars.addComponent(getStarLayout());
            placeNameAndStars.setSizeFull();
            placeNameAndStars.setSplitPosition(50);
            placeNameAndStars.setLocked(true);
        }
        return placeNameAndStars;
    }

    public Label getPlaceName() {
        if(placeName == null)
        {
            placeName = new Label(fullPlace.getName());
            placeName.setSizeFull();
        }
        return placeName;
    }

    public Label getDuration() {
        if(duration == null)
        {
            String time = visit.getVisitTime().getHours() + ":";
            if(visit.getVisitTime().getMinutes() < 10)
            {
                time += "0" + visit.getVisitTime().getMinutes();
            } else
            {
                time += visit.getVisitTime().getMinutes();
            }
            duration = new Label("Starttime: " + time);
            duration.setSizeFull();
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
