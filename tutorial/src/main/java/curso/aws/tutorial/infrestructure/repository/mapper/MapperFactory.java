package curso.aws.tutorial.infrestructure.repository.mapper;

import org.mapstruct.factory.Mappers;

public class MapperFactory {

    private MapperFactory(){}

    public static final PersonMapperDao PERSONA_MAPPER_DAO = Mappers.getMapper(PersonMapperDao.class);

}
