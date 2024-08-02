package org.jboss.as.quickstarts.kitchensink;

import static org.mockito.Mockito.verify;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.service.MemberRegistration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MemberRegistrationIT {

    @Mock
    private Logger log;

    @Mock
    private EntityManager em;

    @Mock
    private ApplicationEventPublisher memberEventSrc;

    @InjectMocks
    private MemberRegistration memberRegistration;

    @Test
    @Transactional
    public void testRegister() throws Exception {
        Member newMember = new Member();
        newMember.setName("Jane Doe");
        newMember.setEmail("jane@mailinator.com");
        newMember.setPhoneNumber("2125551234");
        memberRegistration.register(newMember);

        // Verify interactions
        verify(log).info("Registering " + newMember.getName());
        verify(em).persist(newMember);
        verify(memberEventSrc).publishEvent(newMember);
    }
    
}
