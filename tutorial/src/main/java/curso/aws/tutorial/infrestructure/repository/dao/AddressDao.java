package curso.aws.tutorial.infrestructure.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class AddressDao implements Serializable {

    private String city;
    private String state;
    private String pinCode;

}
