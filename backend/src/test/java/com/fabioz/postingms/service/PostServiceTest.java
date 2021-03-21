package com.fabioz.postingms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author fabioz
 *
 */
@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    
	//InjectMocks
    //private AssociateServiceImpl associateService;

    //Mock
    //private AssociateRepository associateRepository;

    @Test
    void saveAssociateTest(){
        // Arrange
    	/*Associate associate = new Associate();
    	associate.setId(1);
    	associate.setName("User1");
    	associate.setCpf("27611676865");
        
        // Action
        this.associateService.saveAssociate(associate);

        // Assert
        Mockito.verify(this.associateRepository, Mockito.times(1)).save(associate);
    */
    }

    
    @Test
    void getAssociateTest(){
        // Arrange
        Integer id = 1;

        /*Associate associate = new Associate();
        associate.setId(id);
        associate.setName("User2");
        associate.setCpf("33549292864");
        
        Optional<Associate> optionalAssociate = Optional.of(associate);

        Mockito.doReturn(optionalAssociate).when(this.associateRepository).findById(id);

        // Action
        Optional<Associate> optionalAssociate1 = this.associateService.getAssociate(id);

        // Assert
        assertEquals(optionalAssociate, optionalAssociate1);
    */
    
    }
}
