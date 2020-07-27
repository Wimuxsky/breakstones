package com.wimux.breakstones.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author: siqigang
 * @date: 2020/7/1
 * @description:
 **/
@Slf4j
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class TestAsyncServlet extends HttpServlet {

    private Executor executor = new ThreadPoolExecutor(
            10,
            20,
            10, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("async start");
        //开启异步,获取异步上下文
        final AsyncContext ctx = req.startAsync();
        // 提交线程池异步执行
        executor.execute(() -> {
            try {
                log.info("async Service 准备执行了");
                //模拟耗时任务
                Thread.sleep(10000L);
                ctx.getResponse().getWriter().print("async servlet");
                log.info("async Service 执行了");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //最后执行完成后完成回调。
            ctx.complete();
        });
        log.info("async stop");

    }
}
