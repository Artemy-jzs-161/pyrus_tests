package api.extensions;

import api.api.AuthorizationApi;
import api.models.authorization.*;
import org.junit.jupiter.api.extension.*;
import data.TestData;

public class AuthParameterResolver implements ParameterResolver {
    private static final String AUTH_TOKEN = "authToken";
    TestData testData = new TestData();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        return parameterContext.getParameter().getType()
                == String.class
                && parameterContext.getParameter().isAnnotationPresent(AuthToken.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL);

        return store.getOrComputeIfAbsent(AUTH_TOKEN, key -> {
            AuthRequestModel authRequestModel = new AuthRequestModel(testData.email, testData.securityKey);
            AuthorizationApi authorizationApi = new AuthorizationApi();
            AuthResponseModel authResponseModel = authorizationApi.authorize(authRequestModel);
            return authResponseModel.getAccess_token();
        });
    }
}
