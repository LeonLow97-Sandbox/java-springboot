package leon.dev.unitvsintegration;

import org.junit.jupiter.api.Test;
import leon.dev.unitvsintegration.controllers.HelloController;
import static org.junit.jupiter.api.Assertions.*;

public class HelloControllerTest {
    
    @Test
    void hello() {
        HelloController controller = new HelloController(); // Arrange
        String response = controller.hello("Leon"); // Act
        assertEquals("Hello, Leon", response); // Assert
    }

}
