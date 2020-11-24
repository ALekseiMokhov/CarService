package com.senla.carservice.dto.mappers.interfaces;

import com.senla.carservice.dto.PlaceDto;
import com.senla.carservice.dto.mappers.UuidMapper;
import com.senla.carservice.entity.garage.Place;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T21:33:26+0300",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class PlaceMapperImpl implements PlaceMapper {

    @Autowired
    private UuidMapper uuidMapper;

    @Override
    public PlaceDto placeToDto(Place place) {
        if ( place == null ) {
            return null;
        }

        PlaceDto placeDto = new PlaceDto();

        placeDto.setId( uuidMapper.asString( place.getId() ) );
        placeDto.setCalendar( place.getCalendar() );

        return placeDto;
    }

    @Override
    public Place dtoToPlace(PlaceDto placeDto) {
        if ( placeDto == null ) {
            return null;
        }

        Place place = new Place();

        place.setId( uuidMapper.asId( placeDto.getId() ) );
        place.setCalendar( placeDto.getCalendar() );

        return place;
    }

    @Override
    public List<PlaceDto> placesListToDto(List<Place> places) {
        if ( places == null ) {
            return null;
        }

        List<PlaceDto> list = new ArrayList<PlaceDto>( places.size() );
        for ( Place place : places ) {
            list.add( placeToDto( place ) );
        }

        return list;
    }

    @Override
    public List<Place> dtoListToPlaces(List<PlaceDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Place> list = new ArrayList<Place>( dto.size() );
        for ( PlaceDto placeDto : dto ) {
            list.add( dtoToPlace( placeDto ) );
        }

        return list;
    }
}
