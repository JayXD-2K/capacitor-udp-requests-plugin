package com.bdpsolutions.plugin.sender;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    private DatagramSocket socket;
    private InetAddress address;
    private int port;
    private byte[] buffer;

    public Sender(String address, String port) {
        try {
            this.socket = new DatagramSocket();
            this.address = InetAddress.getByName(address);
            this.port = Integer.parseInt(port);
        } catch (Exception e) {
            System.out.println(e.toString());
            this.socket.close();
        }
    }


    public String sendMessage(String message){
        buffer= message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, this.address,this.port);
        try{
            socket.send(packet);
            packet= new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            return received;
        }catch (Exception e){

        }
        return "Error";
    }

    public void close(){
        this.socket.close();
    }
}
