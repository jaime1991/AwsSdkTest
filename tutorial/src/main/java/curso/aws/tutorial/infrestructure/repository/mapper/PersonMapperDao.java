package curso.aws.tutorial.infrestructure.repository.mapper;

import curso.aws.tutorial.infrestructure.repository.dao.PersonDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonMapperDao {

    @Mapping(target = "personId", source = "personIdDao")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "birthDay", source = "birthDay")
    @Mapping(target = "email", source = "email")

    @Mapping(target = "address.city", source = "address.city")
    @Mapping(target = "address.state", source = "address.state")
    @Mapping(target = "address.pinCode", source = "address.pinCode")
    curso.aws.tutorial.domain.model.valueobjects.Person map(PersonDao object);

    @Mapping(source = "personId", target = "personIdDao")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "birthDay", target = "birthDay")
    @Mapping(source = "email", target = "email")

    @Mapping(source = "address.city", target = "address.city")
    @Mapping(source = "address.state", target = "address.state")
    @Mapping(source = "address.pinCode", target = "address.pinCode")
    PersonDao map(curso.aws.tutorial.domain.model.valueobjects.Person object);

}
