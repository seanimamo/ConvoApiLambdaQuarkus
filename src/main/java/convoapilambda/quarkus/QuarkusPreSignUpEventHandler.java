package convoapilambda.quarkus;

import javax.inject.Inject;
import javax.inject.Named;

import cognito.userpool.lambdatriggers.presignup.PreSignUpEventHandler;
import cognito.userpool.lambdatriggers.presignup.PreSignUpEventRequest;
import cognito.userpool.lambdatriggers.presignup.PreSignUpEventResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import handlers.user.CreateUserHandler;
import handlers.util.HandlerHelper;
import org.convo.commons.dynamodb.repository.UserRepository;
import org.convo.commons.singleton.SingletonFactory;

import java.util.Map;

@Named("test")
public class QuarkusPreSignUpEventHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    @Inject
    ProcessingService service;

    private final PreSignUpEventHandler preSignUpEventHandler;

    public QuarkusPreSignUpEventHandler() {
        preSignUpEventHandler = new PreSignUpEventHandler();
    }

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> request, Context context) {
        return preSignUpEventHandler.handleRequest(request, context);
    }
}
