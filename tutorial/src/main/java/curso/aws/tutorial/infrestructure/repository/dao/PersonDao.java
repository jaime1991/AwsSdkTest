package curso.aws.tutorial.infrestructure.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.io.Serializable;
import java.time.LocalDate;

@DynamoDbBean
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDao implements Serializable {

    @Getter(onMethod = @__({@DynamoDbPartitionKey, @DynamoDbAttribute(value = "personId")}))
    private String personIdDao;
    private String name;
    private LocalDate birthDay;
    private String email;
    private AddressDao address;
}
