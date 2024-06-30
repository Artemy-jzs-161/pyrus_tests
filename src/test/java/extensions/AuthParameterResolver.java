package extensions;

import api.AuthorizationApi;
import data.models.authorization.AuthRequestModel;
import data.models.authorization.AuthResponseModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import tests.TestData;

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
            AuthRequestModel authRequestModel = new AuthRequestModel(testData.USERNAME, testData.SECURITY_KEY);
            AuthorizationApi authorizationApi = new AuthorizationApi();
            AuthResponseModel authResponseModel = authorizationApi.authorize(authRequestModel);
            return authResponseModel.getAccess_token();
        });
    }
}
