package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/param")
public class Parameters extends HttpServlet
{

    private PrintWriter out;
    private Map<String, String[]> parameterMap = new HashMap<>();
    private Integer requestSum;
    private Integer totalSum;
    private String totalSumNameAtribute = "TOTAL_SUM";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        out = response.getWriter();


        parameterMap = request.getParameterMap();

        requestSum = 0;
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet())
        {
            Integer paramTabSum = 0;
            String[] values = entry.getValue();
            for (String val : values)
            {
                try { paramTabSum += Integer.parseInt(val); }
                catch (NumberFormatException e) {}
            }
            requestSum += paramTabSum;
        }
        HttpSession session = request.getSession();
        Object fromAtribute = session.getAttribute(totalSumNameAtribute);

        if (fromAtribute == null) totalSum = requestSum;
        else
        {
            totalSum = (Integer) fromAtribute;
            totalSum += requestSum;
        }
        session.setAttribute(totalSumNameAtribute, totalSum);


        out.println("Request sum: " + requestSum);
        out.println("Total sum: " + totalSum);

    }
}
