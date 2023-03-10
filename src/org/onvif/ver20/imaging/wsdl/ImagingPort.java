
package org.onvif.ver20.imaging.wsdl;

import java.util.List;
import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import org.onvif.ver10.schema.FocusMove;
import org.onvif.ver10.schema.ImagingOptions20;
import org.onvif.ver10.schema.ImagingSettings20;
import org.onvif.ver10.schema.ImagingStatus20;
import org.onvif.ver10.schema.MoveOptions20;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ImagingPort", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
@XmlSeeAlso({
    org.oasis_open.docs.wsn.b_2.ObjectFactory.class,
    org.oasis_open.docs.wsn.t_1.ObjectFactory.class,
    org.oasis_open.docs.wsrf.bf_2.ObjectFactory.class,
    org.onvif.ver10.schema.ObjectFactory.class,
    org.onvif.ver20.imaging.wsdl.ObjectFactory.class,
    org.w3._2003._05.soap_envelope.ObjectFactory.class,
    org.w3._2004._08.xop.include.ObjectFactory.class,
    org.w3._2005._05.xmlmime.ObjectFactory.class,
    org.w3._2005._08.addressing.ObjectFactory.class
})
public interface ImagingPort {


    /**
     * Returns the capabilities of the imaging service. The result is returned in a typed answer.
     * 
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.GetServiceCapabilitiesResponse>
     */
    @WebMethod(operationName = "GetServiceCapabilities", action = "http://www.onvif.org/ver20/imaging/wsdl/GetServiceCapabilities")
    @RequestWrapper(localName = "GetServiceCapabilities", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetServiceCapabilities")
    @ResponseWrapper(localName = "GetServiceCapabilitiesResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetServiceCapabilitiesResponse")
    public Response<GetServiceCapabilitiesResponse> getServiceCapabilitiesAsync();

    /**
     * Returns the capabilities of the imaging service. The result is returned in a typed answer.
     * 
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetServiceCapabilities", action = "http://www.onvif.org/ver20/imaging/wsdl/GetServiceCapabilities")
    @RequestWrapper(localName = "GetServiceCapabilities", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetServiceCapabilities")
    @ResponseWrapper(localName = "GetServiceCapabilitiesResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetServiceCapabilitiesResponse")
    public Future<?> getServiceCapabilitiesAsync(
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetServiceCapabilitiesResponse> asyncHandler);

    /**
     * Returns the capabilities of the imaging service. The result is returned in a typed answer.
     * 
     * @return
     *     returns org.onvif.ver20.imaging.wsdl.Capabilities
     */
    @WebMethod(operationName = "GetServiceCapabilities", action = "http://www.onvif.org/ver20/imaging/wsdl/GetServiceCapabilities")
    @WebResult(name = "Capabilities", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
    @RequestWrapper(localName = "GetServiceCapabilities", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetServiceCapabilities")
    @ResponseWrapper(localName = "GetServiceCapabilitiesResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetServiceCapabilitiesResponse")
    public Capabilities getServiceCapabilities();

    /**
     * Get the ImagingConfiguration for the requested VideoSource.
     * 
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.GetImagingSettingsResponse>
     */
    @WebMethod(operationName = "GetImagingSettings", action = "http://www.onvif.org/ver20/imaging/wsdl/GetImagingSettings")
    @RequestWrapper(localName = "GetImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetImagingSettings")
    @ResponseWrapper(localName = "GetImagingSettingsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetImagingSettingsResponse")
    public Response<GetImagingSettingsResponse> getImagingSettingsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Get the ImagingConfiguration for the requested VideoSource.
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetImagingSettings", action = "http://www.onvif.org/ver20/imaging/wsdl/GetImagingSettings")
    @RequestWrapper(localName = "GetImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetImagingSettings")
    @ResponseWrapper(localName = "GetImagingSettingsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetImagingSettingsResponse")
    public Future<?> getImagingSettingsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetImagingSettingsResponse> asyncHandler);

    /**
     * Get the ImagingConfiguration for the requested VideoSource.
     * 
     * @param videoSourceToken
     * @return
     *     returns org.onvif.ver10.schema.ImagingSettings20
     */
    @WebMethod(operationName = "GetImagingSettings", action = "http://www.onvif.org/ver20/imaging/wsdl/GetImagingSettings")
    @WebResult(name = "ImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
    @RequestWrapper(localName = "GetImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetImagingSettings")
    @ResponseWrapper(localName = "GetImagingSettingsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetImagingSettingsResponse")
    public ImagingSettings20 getImagingSettings(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Set the ImagingConfiguration for the requested VideoSource.
     * 
     * @param imagingSettings
     * @param videoSourceToken
     * @param forcePersistence
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.SetImagingSettingsResponse>
     */
    @WebMethod(operationName = "SetImagingSettings", action = "http://www.onvif.org/ver20/imaging/wsdl/SetImagingSettings")
    @RequestWrapper(localName = "SetImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetImagingSettings")
    @ResponseWrapper(localName = "SetImagingSettingsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetImagingSettingsResponse")
    public Response<SetImagingSettingsResponse> setImagingSettingsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "ImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        ImagingSettings20 imagingSettings,
        @WebParam(name = "ForcePersistence", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        Boolean forcePersistence);

    /**
     * Set the ImagingConfiguration for the requested VideoSource.
     * 
     * @param imagingSettings
     * @param videoSourceToken
     * @param forcePersistence
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "SetImagingSettings", action = "http://www.onvif.org/ver20/imaging/wsdl/SetImagingSettings")
    @RequestWrapper(localName = "SetImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetImagingSettings")
    @ResponseWrapper(localName = "SetImagingSettingsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetImagingSettingsResponse")
    public Future<?> setImagingSettingsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "ImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        ImagingSettings20 imagingSettings,
        @WebParam(name = "ForcePersistence", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        Boolean forcePersistence,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<SetImagingSettingsResponse> asyncHandler);

    /**
     * Set the ImagingConfiguration for the requested VideoSource.
     * 
     * @param imagingSettings
     * @param videoSourceToken
     * @param forcePersistence
     */
    @WebMethod(operationName = "SetImagingSettings", action = "http://www.onvif.org/ver20/imaging/wsdl/SetImagingSettings")
    @RequestWrapper(localName = "SetImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetImagingSettings")
    @ResponseWrapper(localName = "SetImagingSettingsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetImagingSettingsResponse")
    public void setImagingSettings(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "ImagingSettings", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        ImagingSettings20 imagingSettings,
        @WebParam(name = "ForcePersistence", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        Boolean forcePersistence);

    /**
     * 
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.GetOptionsResponse>
     */
    @WebMethod(operationName = "GetOptions", action = "http://www.onvif.org/ver20/imaging/wsdl/GetOptions")
    @RequestWrapper(localName = "GetOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetOptions")
    @ResponseWrapper(localName = "GetOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetOptionsResponse")
    public Response<GetOptionsResponse> getOptionsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetOptions", action = "http://www.onvif.org/ver20/imaging/wsdl/GetOptions")
    @RequestWrapper(localName = "GetOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetOptions")
    @ResponseWrapper(localName = "GetOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetOptionsResponse")
    public Future<?> getOptionsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetOptionsResponse> asyncHandler);

    /**
     * 
     * @param videoSourceToken
     * @return
     *     returns org.onvif.ver10.schema.ImagingOptions20
     */
    @WebMethod(operationName = "GetOptions", action = "http://www.onvif.org/ver20/imaging/wsdl/GetOptions")
    @WebResult(name = "ImagingOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
    @RequestWrapper(localName = "GetOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetOptions")
    @ResponseWrapper(localName = "GetOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetOptionsResponse")
    public ImagingOptions20 getOptions(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * 
     * @param videoSourceToken
     * @param focus
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.MoveResponse>
     */
    @WebMethod(operationName = "Move", action = "http://www.onvif.org/ver20/imaging/wsdl/Move")
    @RequestWrapper(localName = "Move", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.Move")
    @ResponseWrapper(localName = "MoveResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.MoveResponse")
    public Response<MoveResponse> moveAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "Focus", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        FocusMove focus);

    /**
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @param focus
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "Move", action = "http://www.onvif.org/ver20/imaging/wsdl/Move")
    @RequestWrapper(localName = "Move", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.Move")
    @ResponseWrapper(localName = "MoveResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.MoveResponse")
    public Future<?> moveAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "Focus", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        FocusMove focus,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<MoveResponse> asyncHandler);

    /**
     * 
     * @param videoSourceToken
     * @param focus
     */
    @WebMethod(operationName = "Move", action = "http://www.onvif.org/ver20/imaging/wsdl/Move")
    @RequestWrapper(localName = "Move", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.Move")
    @ResponseWrapper(localName = "MoveResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.MoveResponse")
    public void move(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "Focus", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        FocusMove focus);

    /**
     * 
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.StopResponse>
     */
    @WebMethod(operationName = "Stop", action = "http://www.onvif.org/ver20/imaging/wsdl/FocusStop")
    @RequestWrapper(localName = "Stop", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.Stop")
    @ResponseWrapper(localName = "StopResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.StopResponse")
    public Response<StopResponse> stopAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "Stop", action = "http://www.onvif.org/ver20/imaging/wsdl/FocusStop")
    @RequestWrapper(localName = "Stop", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.Stop")
    @ResponseWrapper(localName = "StopResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.StopResponse")
    public Future<?> stopAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<StopResponse> asyncHandler);

    /**
     * 
     * @param videoSourceToken
     */
    @WebMethod(operationName = "Stop", action = "http://www.onvif.org/ver20/imaging/wsdl/FocusStop")
    @RequestWrapper(localName = "Stop", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.Stop")
    @ResponseWrapper(localName = "StopResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.StopResponse")
    public void stop(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Via this command the current status of the Move operation can be requested. Supported for this command is available if the support for the Move operation is signalled via GetMoveOptions.
     * 
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.GetStatusResponse>
     */
    @WebMethod(operationName = "GetStatus", action = "http://www.onvif.org/ver20/imaging/wsdl/GetStatus")
    @RequestWrapper(localName = "GetStatus", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetStatus")
    @ResponseWrapper(localName = "GetStatusResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetStatusResponse")
    public Response<GetStatusResponse> getStatusAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Via this command the current status of the Move operation can be requested. Supported for this command is available if the support for the Move operation is signalled via GetMoveOptions.
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetStatus", action = "http://www.onvif.org/ver20/imaging/wsdl/GetStatus")
    @RequestWrapper(localName = "GetStatus", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetStatus")
    @ResponseWrapper(localName = "GetStatusResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetStatusResponse")
    public Future<?> getStatusAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetStatusResponse> asyncHandler);

    /**
     * Via this command the current status of the Move operation can be requested. Supported for this command is available if the support for the Move operation is signalled via GetMoveOptions.
     * 
     * @param videoSourceToken
     * @return
     *     returns org.onvif.ver10.schema.ImagingStatus20
     */
    @WebMethod(operationName = "GetStatus", action = "http://www.onvif.org/ver20/imaging/wsdl/GetStatus")
    @WebResult(name = "Status", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
    @RequestWrapper(localName = "GetStatus", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetStatus")
    @ResponseWrapper(localName = "GetStatusResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetStatusResponse")
    public ImagingStatus20 getStatus(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Imaging move operation options supported for the Video source.
     * 
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.GetMoveOptionsResponse>
     */
    @WebMethod(operationName = "GetMoveOptions", action = "http://www.onvif.org/ver20/imaging/wsdl/GetMoveOptions")
    @RequestWrapper(localName = "GetMoveOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetMoveOptions")
    @ResponseWrapper(localName = "GetMoveOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetMoveOptionsResponse")
    public Response<GetMoveOptionsResponse> getMoveOptionsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Imaging move operation options supported for the Video source.
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetMoveOptions", action = "http://www.onvif.org/ver20/imaging/wsdl/GetMoveOptions")
    @RequestWrapper(localName = "GetMoveOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetMoveOptions")
    @ResponseWrapper(localName = "GetMoveOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetMoveOptionsResponse")
    public Future<?> getMoveOptionsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetMoveOptionsResponse> asyncHandler);

    /**
     * Imaging move operation options supported for the Video source.
     * 
     * @param videoSourceToken
     * @return
     *     returns org.onvif.ver10.schema.MoveOptions20
     */
    @WebMethod(operationName = "GetMoveOptions", action = "http://www.onvif.org/ver20/imaging/wsdl/GetMoveOptions")
    @WebResult(name = "MoveOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
    @RequestWrapper(localName = "GetMoveOptions", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetMoveOptions")
    @ResponseWrapper(localName = "GetMoveOptionsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetMoveOptionsResponse")
    public MoveOptions20 getMoveOptions(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Via this command the list of available Imaging Presets can be requested.
     * 
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.GetPresetsResponse>
     */
    @WebMethod(operationName = "GetPresets", action = "http://www.onvif.org/ver20/imaging/wsdl/GetPresets")
    @RequestWrapper(localName = "GetPresets", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetPresets")
    @ResponseWrapper(localName = "GetPresetsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetPresetsResponse")
    public Response<GetPresetsResponse> getPresetsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Via this command the list of available Imaging Presets can be requested.
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetPresets", action = "http://www.onvif.org/ver20/imaging/wsdl/GetPresets")
    @RequestWrapper(localName = "GetPresets", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetPresets")
    @ResponseWrapper(localName = "GetPresetsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetPresetsResponse")
    public Future<?> getPresetsAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetPresetsResponse> asyncHandler);

    /**
     * Via this command the list of available Imaging Presets can be requested.
     * 
     * @param videoSourceToken
     * @return
     *     returns java.util.List<org.onvif.ver20.imaging.wsdl.ImagingPreset>
     */
    @WebMethod(operationName = "GetPresets", action = "http://www.onvif.org/ver20/imaging/wsdl/GetPresets")
    @WebResult(name = "Preset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
    @RequestWrapper(localName = "GetPresets", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetPresets")
    @ResponseWrapper(localName = "GetPresetsResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetPresetsResponse")
    public List<ImagingPreset> getPresets(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Via this command the last Imaging Preset applied can be requested. 
     * 			If the camera configuration does not match any of the existing Imaging Presets, the output of GetCurrentPreset shall be Empty.
     * 			GetCurrentPreset shall return 0 if Imaging Presets are not supported by the Video Source.
     * 
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.GetCurrentPresetResponse>
     */
    @WebMethod(operationName = "GetCurrentPreset", action = "http://www.onvif.org/ver20/imaging/wsdl/GetCurrentPreset")
    @RequestWrapper(localName = "GetCurrentPreset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetCurrentPreset")
    @ResponseWrapper(localName = "GetCurrentPresetResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetCurrentPresetResponse")
    public Response<GetCurrentPresetResponse> getCurrentPresetAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * Via this command the last Imaging Preset applied can be requested. 
     * 			If the camera configuration does not match any of the existing Imaging Presets, the output of GetCurrentPreset shall be Empty.
     * 			GetCurrentPreset shall return 0 if Imaging Presets are not supported by the Video Source.
     * 
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetCurrentPreset", action = "http://www.onvif.org/ver20/imaging/wsdl/GetCurrentPreset")
    @RequestWrapper(localName = "GetCurrentPreset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetCurrentPreset")
    @ResponseWrapper(localName = "GetCurrentPresetResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetCurrentPresetResponse")
    public Future<?> getCurrentPresetAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetCurrentPresetResponse> asyncHandler);

    /**
     * Via this command the last Imaging Preset applied can be requested. 
     * 			If the camera configuration does not match any of the existing Imaging Presets, the output of GetCurrentPreset shall be Empty.
     * 			GetCurrentPreset shall return 0 if Imaging Presets are not supported by the Video Source.
     * 
     * @param videoSourceToken
     * @return
     *     returns org.onvif.ver20.imaging.wsdl.ImagingPreset
     */
    @WebMethod(operationName = "GetCurrentPreset", action = "http://www.onvif.org/ver20/imaging/wsdl/GetCurrentPreset")
    @WebResult(name = "Preset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
    @RequestWrapper(localName = "GetCurrentPreset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetCurrentPreset")
    @ResponseWrapper(localName = "GetCurrentPresetResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.GetCurrentPresetResponse")
    public ImagingPreset getCurrentPreset(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken);

    /**
     * The SetCurrentPreset command shall request a given Imaging Preset to be applied to the specified Video Source.
     * 			SetCurrentPreset shall only be available for Video Sources with Imaging Presets Capability. 
     * 			Imaging Presets are defined by the Manufacturer, and offered as a tool to simplify Imaging Settings adjustments for specific scene content.
     * 			When the new Imaging Preset is applied by SetCurrentPreset, the Device shall adjust the Video Source settings to match those defined by the specified Imaging Preset.
     * 
     * @param presetToken
     * @param videoSourceToken
     * @return
     *     returns javax.xml.ws.Response<org.onvif.ver20.imaging.wsdl.SetCurrentPresetResponse>
     */
    @WebMethod(operationName = "SetCurrentPreset", action = "http://www.onvif.org/ver20/imaging/wsdl/SetCurrentPreset")
    @RequestWrapper(localName = "SetCurrentPreset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetCurrentPreset")
    @ResponseWrapper(localName = "SetCurrentPresetResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetCurrentPresetResponse")
    public Response<SetCurrentPresetResponse> setCurrentPresetAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "PresetToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String presetToken);

    /**
     * The SetCurrentPreset command shall request a given Imaging Preset to be applied to the specified Video Source.
     * 			SetCurrentPreset shall only be available for Video Sources with Imaging Presets Capability. 
     * 			Imaging Presets are defined by the Manufacturer, and offered as a tool to simplify Imaging Settings adjustments for specific scene content.
     * 			When the new Imaging Preset is applied by SetCurrentPreset, the Device shall adjust the Video Source settings to match those defined by the specified Imaging Preset.
     * 
     * @param presetToken
     * @param videoSourceToken
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "SetCurrentPreset", action = "http://www.onvif.org/ver20/imaging/wsdl/SetCurrentPreset")
    @RequestWrapper(localName = "SetCurrentPreset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetCurrentPreset")
    @ResponseWrapper(localName = "SetCurrentPresetResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetCurrentPresetResponse")
    public Future<?> setCurrentPresetAsync(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "PresetToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String presetToken,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<SetCurrentPresetResponse> asyncHandler);

    /**
     * The SetCurrentPreset command shall request a given Imaging Preset to be applied to the specified Video Source.
     * 			SetCurrentPreset shall only be available for Video Sources with Imaging Presets Capability. 
     * 			Imaging Presets are defined by the Manufacturer, and offered as a tool to simplify Imaging Settings adjustments for specific scene content.
     * 			When the new Imaging Preset is applied by SetCurrentPreset, the Device shall adjust the Video Source settings to match those defined by the specified Imaging Preset.
     * 
     * @param presetToken
     * @param videoSourceToken
     */
    @WebMethod(operationName = "SetCurrentPreset", action = "http://www.onvif.org/ver20/imaging/wsdl/SetCurrentPreset")
    @RequestWrapper(localName = "SetCurrentPreset", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetCurrentPreset")
    @ResponseWrapper(localName = "SetCurrentPresetResponse", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl", className = "org.onvif.ver20.imaging.wsdl.SetCurrentPresetResponse")
    public void setCurrentPreset(
        @WebParam(name = "VideoSourceToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String videoSourceToken,
        @WebParam(name = "PresetToken", targetNamespace = "http://www.onvif.org/ver20/imaging/wsdl")
        String presetToken);

}
