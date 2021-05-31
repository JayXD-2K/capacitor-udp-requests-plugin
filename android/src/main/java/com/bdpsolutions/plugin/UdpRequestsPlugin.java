package com.bdpsolutions.plugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "UdpRequests")
public class UdpRequestsPlugin extends Plugin {

    private UdpRequests implementation = new UdpRequests();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void sendUdpRequest(PluginCall call){
        String address = call.getString("address");
        String port = call.getString("port");
        String payload = call.getString("payload");



        call.resolve();
    }


}
