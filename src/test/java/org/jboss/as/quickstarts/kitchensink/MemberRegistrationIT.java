package org.jboss.as.quickstarts.kitchensink;

import static org.mockito.Mockito.verify;

import org.jboss.as.quickstarts.kitchensink.data.MemberRepository;
import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.service.MemberRegistration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.context.ApplicationEventPublisher;

@ExtendWith(MockitoExtension.class)
public class MemberRegistrationIT {

    @Mock
    private Logger log;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private ApplicationEventPublisher memberEventPublisher;

    @InjectMocks
    private MemberRegistration memberRegistration; // Inject mocks into this class

    @Test
    public void testRegister() throws Exception {
        Member newMember = new Member();
        newMember.setName("Jane Doe");
        newMember.setEmail("jane@mailinator.com");
        newMember.setPhoneNumber("2125551234");

        // Act
        memberRegistration.register(newMember);

        // Verify interactions
        verify(log).info("Registering " + newMember.getName()); // Verify logger was called
        verify(memberRepository).save(newMember); // Verify repository's save method was called
        verify(memberEventPublisher).publishEvent(newMember); // Verify event publisher was called
    }
    
    @AfterEach
    void tearDown() {
        // Cleanup test data
        memberRepository.deleteAll(); // Or specific cleanup operations
    }
}
