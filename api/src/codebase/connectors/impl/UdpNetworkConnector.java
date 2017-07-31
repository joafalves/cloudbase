package codebase.connectors.impl;

import codebase.connectors.NetworkConnector;

import codebase.handlers.StandardUpstreamHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UdpNetworkConnector implements NetworkConnector {

    private static final Logger logger = LogManager.getLogger(UdpNetworkConnector.class);

    private Bootstrap bootstrap;

    @Override
    public void init() {
        logger.trace("Booting UdpNetworkConnector..");

        bootstrap = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioDatagramChannel.class)
                .localAddress(8010)
                .handler(new ChannelInitializer<NioDatagramChannel>() {
                    @Override
                    public void initChannel(final NioDatagramChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new StandardUpstreamHandler());
                    }
                });
    }
}
