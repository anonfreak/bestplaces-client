package de.bestplaces.view.dashboard.components;


import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.Panel;
import de.bestplaces.model.FullPlace;

/**
 * Created by franz on 08.05.2017.
 */
public class GoogleMapsPanel extends Panel {

    public GoogleMapsPanel(FullPlace place)
    {
        GoogleMap googleMap = new GoogleMap(null, null, null);
        googleMap.setCenter(new LatLon(place.getGeo().getLatitude(), place.getGeo().getLongitude()));
        //Values from 1(far) to 20(near)
        googleMap.setZoom(15);
        googleMap.setSizeFull();

        GoogleMapMarker placeMarker = new GoogleMapMarker(
                place.getName(), new LatLon(place.getGeo().getLatitude(), place.getGeo().getLongitude()),
                true, null);


        placeMarker.setAnimationEnabled(false);
        googleMap.addMarker(placeMarker);

        setContent(googleMap);
        setSizeFull();
    }


}
