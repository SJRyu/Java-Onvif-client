
package org.onvif.ver20.analytics.wsdl;

import java.util.List;
import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import org.onvif.ver10.schema.Config;
import org.onvif.ver10.schema.SupportedAnalyticsModules;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AnalyticsEnginePort", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
@XmlSeeAlso({
    org.oasis_open.docs.wsn.b_2.ObjectFactory.class,
    org.oasis_open.docs.wsn.t_1.ObjectFactory.class,
    org.oasis_open.docs.wsrf.bf_2.ObjectFactory.class,
    org.onvif.ver10.schema.ObjectFactory.class,
    org.onvif.ver20.analytics.wsdl.ObjectFactory.class,
    org.w3._2003._05.soap_envelope.ObjectFactory.class,
    org.w3._2004._08.xop.include.ObjectFactory.class,
    org.w3._2005._05.xmlmime.ObjectFactory.class,
    org.w3._2005._08.addressing.ObjectFactory.class
})
public interface AnalyticsEnginePort {


    /**
     * Returns the capabilities of the analytics service. The result is returned in a typed answer.
     * 
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.analytics.wsdl.GetServiceCapabilitiesResponse>
     */
    @WebMethod(operationName = "GetServiceCapabilities", action = "http://www.onvif.org/ver20/analytics/wsdl/GetServiceCapabilities")
    @RequestWrapper(localName = "GetServiceCapabilities", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetServiceCapabilities")
    @ResponseWrapper(localName = "GetServiceCapabilitiesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetServiceCapabilitiesResponse")
    public Response<GetServiceCapabilitiesResponse> getServiceCapabilitiesAsync();

    /**
     * Returns the capabilities of the analytics service. The result is returned in a typed answer.
     * 
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetServiceCapabilities", action = "http://www.onvif.org/ver20/analytics/wsdl/GetServiceCapabilities")
    @RequestWrapper(localName = "GetServiceCapabilities", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetServiceCapabilities")
    @ResponseWrapper(localName = "GetServiceCapabilitiesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetServiceCapabilitiesResponse")
    public Future<?> getServiceCapabilitiesAsync(
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetServiceCapabilitiesResponse> asyncHandler);

    /**
     * Returns the capabilities of the analytics service. The result is returned in a typed answer.
     * 
     * @return
     *     returns org.onvif.ver20.analytics.wsdl.Capabilities
     */
    @WebMethod(operationName = "GetServiceCapabilities", action = "http://www.onvif.org/ver20/analytics/wsdl/GetServiceCapabilities")
    @WebResult(name = "Capabilities", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
    @RequestWrapper(localName = "GetServiceCapabilities", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetServiceCapabilities")
    @ResponseWrapper(localName = "GetServiceCapabilitiesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetServiceCapabilitiesResponse")
    public Capabilities getServiceCapabilities();

    /**
     * 
     * 				List all analytics modules that are supported by the given VideoAnalyticsConfiguration.
     * 			
     * 
     * @param configurationToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.analytics.wsdl.GetSupportedAnalyticsModulesResponse>
     */
    @WebMethod(operationName = "GetSupportedAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/GetSupportedAnalyticsModules")
    @RequestWrapper(localName = "GetSupportedAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetSupportedAnalyticsModules")
    @ResponseWrapper(localName = "GetSupportedAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetSupportedAnalyticsModulesResponse")
    public Response<GetSupportedAnalyticsModulesResponse> getSupportedAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken);

    /**
     * 
     * 				List all analytics modules that are supported by the given VideoAnalyticsConfiguration.
     * 			
     * 
     * @param configurationToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetSupportedAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/GetSupportedAnalyticsModules")
    @RequestWrapper(localName = "GetSupportedAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetSupportedAnalyticsModules")
    @ResponseWrapper(localName = "GetSupportedAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetSupportedAnalyticsModulesResponse")
    public Future<?> getSupportedAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetSupportedAnalyticsModulesResponse> asyncHandler);

    /**
     * 
     * 				List all analytics modules that are supported by the given VideoAnalyticsConfiguration.
     * 			
     * 
     * @param configurationToken
     * @return
     *     returns org.onvif.ver10.schema.SupportedAnalyticsModules
     */
    @WebMethod(operationName = "GetSupportedAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/GetSupportedAnalyticsModules")
    @WebResult(name = "SupportedAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
    @RequestWrapper(localName = "GetSupportedAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetSupportedAnalyticsModules")
    @ResponseWrapper(localName = "GetSupportedAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetSupportedAnalyticsModulesResponse")
    public SupportedAnalyticsModules getSupportedAnalyticsModules(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken);

    /**
     * 
     * @param analyticsModule
     * @param configurationToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.analytics.wsdl.CreateAnalyticsModulesResponse>
     */
    @WebMethod(operationName = "CreateAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/CreateAnalyticsModules")
    @RequestWrapper(localName = "CreateAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.CreateAnalyticsModules")
    @ResponseWrapper(localName = "CreateAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.CreateAnalyticsModulesResponse")
    public Response<CreateAnalyticsModulesResponse> createAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModule", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<Config> analyticsModule);

    /**
     * 
     * @param analyticsModule
     * @param configurationToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "CreateAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/CreateAnalyticsModules")
    @RequestWrapper(localName = "CreateAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.CreateAnalyticsModules")
    @ResponseWrapper(localName = "CreateAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.CreateAnalyticsModulesResponse")
    public Future<?> createAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModule", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<Config> analyticsModule,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<CreateAnalyticsModulesResponse> asyncHandler);

    /**
     * 
     * @param analyticsModule
     * @param configurationToken
     */
    @WebMethod(operationName = "CreateAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/CreateAnalyticsModules")
    @RequestWrapper(localName = "CreateAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.CreateAnalyticsModules")
    @ResponseWrapper(localName = "CreateAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.CreateAnalyticsModulesResponse")
    public void createAnalyticsModules(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModule", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<Config> analyticsModule);

    /**
     * 
     * @param configurationToken
     * @param analyticsModuleName
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.analytics.wsdl.DeleteAnalyticsModulesResponse>
     */
    @WebMethod(operationName = "DeleteAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/DeleteAnalyticsModules")
    @RequestWrapper(localName = "DeleteAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.DeleteAnalyticsModules")
    @ResponseWrapper(localName = "DeleteAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.DeleteAnalyticsModulesResponse")
    public Response<DeleteAnalyticsModulesResponse> deleteAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModuleName", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<String> analyticsModuleName);

    /**
     * 
     * @param configurationToken
     * @param asyncHandler
     * @param analyticsModuleName
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "DeleteAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/DeleteAnalyticsModules")
    @RequestWrapper(localName = "DeleteAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.DeleteAnalyticsModules")
    @ResponseWrapper(localName = "DeleteAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.DeleteAnalyticsModulesResponse")
    public Future<?> deleteAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModuleName", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<String> analyticsModuleName,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<DeleteAnalyticsModulesResponse> asyncHandler);

    /**
     * 
     * @param configurationToken
     * @param analyticsModuleName
     */
    @WebMethod(operationName = "DeleteAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/DeleteAnalyticsModules")
    @RequestWrapper(localName = "DeleteAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.DeleteAnalyticsModules")
    @ResponseWrapper(localName = "DeleteAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.DeleteAnalyticsModulesResponse")
    public void deleteAnalyticsModules(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModuleName", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<String> analyticsModuleName);

    /**
     * 
     * 				List the currently assigned set of analytics modules of a VideoAnalyticsConfiguration.
     * 			
     * 
     * @param configurationToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.analytics.wsdl.GetAnalyticsModulesResponse>
     */
    @WebMethod(operationName = "GetAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/GetAnalyticsModules")
    @RequestWrapper(localName = "GetAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModules")
    @ResponseWrapper(localName = "GetAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModulesResponse")
    public Response<GetAnalyticsModulesResponse> getAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken);

    /**
     * 
     * 				List the currently assigned set of analytics modules of a VideoAnalyticsConfiguration.
     * 			
     * 
     * @param configurationToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/GetAnalyticsModules")
    @RequestWrapper(localName = "GetAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModules")
    @ResponseWrapper(localName = "GetAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModulesResponse")
    public Future<?> getAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetAnalyticsModulesResponse> asyncHandler);

    /**
     * 
     * 				List the currently assigned set of analytics modules of a VideoAnalyticsConfiguration.
     * 			
     * 
     * @param configurationToken
     * @return
     *     returns java.util.List<org.onvif.ver10.schema.Config>
     */
    @WebMethod(operationName = "GetAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/GetAnalyticsModules")
    @WebResult(name = "AnalyticsModule", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
    @RequestWrapper(localName = "GetAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModules")
    @ResponseWrapper(localName = "GetAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModulesResponse")
    public List<Config> getAnalyticsModules(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken);

    /**
     * 
     * 				Return the options for the supported analytics modules that specify an Option attribute.
     * 			
     * 
     * @param configurationToken
     * @param type
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.analytics.wsdl.GetAnalyticsModuleOptionsResponse>
     */
    @WebMethod(operationName = "GetAnalyticsModuleOptions", action = "http://www.onvif.org/ver20/analytics/wsdl/GetAnalyticsModuleOptions")
    @RequestWrapper(localName = "GetAnalyticsModuleOptions", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModuleOptions")
    @ResponseWrapper(localName = "GetAnalyticsModuleOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModuleOptionsResponse")
    public Response<GetAnalyticsModuleOptionsResponse> getAnalyticsModuleOptionsAsync(
        @WebParam(name = "Type", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        QName type,
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken);

    /**
     * 
     * 				Return the options for the supported analytics modules that specify an Option attribute.
     * 			
     * 
     * @param configurationToken
     * @param asyncHandler
     * @param type
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetAnalyticsModuleOptions", action = "http://www.onvif.org/ver20/analytics/wsdl/GetAnalyticsModuleOptions")
    @RequestWrapper(localName = "GetAnalyticsModuleOptions", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModuleOptions")
    @ResponseWrapper(localName = "GetAnalyticsModuleOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModuleOptionsResponse")
    public Future<?> getAnalyticsModuleOptionsAsync(
        @WebParam(name = "Type", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        QName type,
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetAnalyticsModuleOptionsResponse> asyncHandler);

    /**
     * 
     * 				Return the options for the supported analytics modules that specify an Option attribute.
     * 			
     * 
     * @param configurationToken
     * @param type
     * @return
     *     returns java.util.List<org.onvif.ver20.analytics.wsdl.ConfigOptions>
     */
    @WebMethod(operationName = "GetAnalyticsModuleOptions", action = "http://www.onvif.org/ver20/analytics/wsdl/GetAnalyticsModuleOptions")
    @WebResult(name = "Options", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
    @RequestWrapper(localName = "GetAnalyticsModuleOptions", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModuleOptions")
    @ResponseWrapper(localName = "GetAnalyticsModuleOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.GetAnalyticsModuleOptionsResponse")
    public List<ConfigOptions> getAnalyticsModuleOptions(
        @WebParam(name = "Type", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        QName type,
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken);

    /**
     * 
     * 				Modify the settings of one or more analytics modules of a VideoAnalyticsConfiguration. The modules are referenced by their names.
     * 				It is allowed to pass only a subset to be modified.
     * 			
     * 
     * @param analyticsModule
     * @param configurationToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.analytics.wsdl.ModifyAnalyticsModulesResponse>
     */
    @WebMethod(operationName = "ModifyAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/ModifyAnalyticsModules")
    @RequestWrapper(localName = "ModifyAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.ModifyAnalyticsModules")
    @ResponseWrapper(localName = "ModifyAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.ModifyAnalyticsModulesResponse")
    public Response<ModifyAnalyticsModulesResponse> modifyAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModule", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<Config> analyticsModule);

    /**
     * 
     * 				Modify the settings of one or more analytics modules of a VideoAnalyticsConfiguration. The modules are referenced by their names.
     * 				It is allowed to pass only a subset to be modified.
     * 			
     * 
     * @param analyticsModule
     * @param configurationToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "ModifyAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/ModifyAnalyticsModules")
    @RequestWrapper(localName = "ModifyAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.ModifyAnalyticsModules")
    @ResponseWrapper(localName = "ModifyAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.ModifyAnalyticsModulesResponse")
    public Future<?> modifyAnalyticsModulesAsync(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModule", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<Config> analyticsModule,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<ModifyAnalyticsModulesResponse> asyncHandler);

    /**
     * 
     * 				Modify the settings of one or more analytics modules of a VideoAnalyticsConfiguration. The modules are referenced by their names.
     * 				It is allowed to pass only a subset to be modified.
     * 			
     * 
     * @param analyticsModule
     * @param configurationToken
     */
    @WebMethod(operationName = "ModifyAnalyticsModules", action = "http://www.onvif.org/ver20/analytics/wsdl/ModifyAnalyticsModules")
    @RequestWrapper(localName = "ModifyAnalyticsModules", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.ModifyAnalyticsModules")
    @ResponseWrapper(localName = "ModifyAnalyticsModulesResponse", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl", className = "org.onvif.ver20.analytics.wsdl.ModifyAnalyticsModulesResponse")
    public void modifyAnalyticsModules(
        @WebParam(name = "ConfigurationToken", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        String configurationToken,
        @WebParam(name = "AnalyticsModule", targetNamespace = "http://www.onvif.org/ver20/analytics/wsdl")
        List<Config> analyticsModule);

}
