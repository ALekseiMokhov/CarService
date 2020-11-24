package com.senla.carservice.dto.mappers.interfaces;

import com.senla.carservice.dto.MasterDto;
import com.senla.carservice.dto.mappers.SpecialityMapper;
import com.senla.carservice.dto.mappers.UuidMapper;
import com.senla.carservice.entity.master.Master;
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
public class MasterMapperImpl implements MasterMapper {

    @Autowired
    private UuidMapper uuidMapper;
    @Autowired
    private SpecialityMapper specialityMapper;

    @Override
    public MasterDto masterToDto(Master master) {
        if ( master == null ) {
            return null;
        }

        MasterDto masterDto = new MasterDto();

        masterDto.setId( uuidMapper.asString( master.getId() ) );
        masterDto.setCalendar( master.getCalendar() );
        masterDto.setFullName( master.getFullName() );
        masterDto.setDailyPayment( master.getDailyPayment() );
        masterDto.setSpeciality( specialityMapper.asString( master.getSpeciality() ) );

        return masterDto;
    }

    @Override
    public Master masterFromDto(MasterDto masterDto) {
        if ( masterDto == null ) {
            return null;
        }

        Master master = new Master();

        master.setId( uuidMapper.asId( masterDto.getId() ) );
        master.setCalendar( masterDto.getCalendar() );
        master.setFullName( masterDto.getFullName() );
        master.setDailyPayment( masterDto.getDailyPayment() );
        master.setSpeciality( specialityMapper.asSpeciality( masterDto.getSpeciality() ) );

        return master;
    }

    @Override
    public List<MasterDto> mastersToDto(List<Master> masters) {
        if ( masters == null ) {
            return null;
        }

        List<MasterDto> list = new ArrayList<MasterDto>( masters.size() );
        for ( Master master : masters ) {
            list.add( masterToDto( master ) );
        }

        return list;
    }

    @Override
    public List<Master> dtoToMasters(List<MasterDto> masterdto) {
        if ( masterdto == null ) {
            return null;
        }

        List<Master> list = new ArrayList<Master>( masterdto.size() );
        for ( MasterDto masterDto : masterdto ) {
            list.add( masterFromDto( masterDto ) );
        }

        return list;
    }
}
