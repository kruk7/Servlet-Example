package servlet;

import model.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductSearchPatern", value = "/search-patern")
public class ProductSearchPatern extends HttpServlet
{
    @Inject
    private EntityManager em;
    private List<Product> resultList;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        if (Boolean.parseBoolean(request.getParameter("parameter")))
        {
            String whatDo = request.getParameter("what-do");
            TypedQuery<Product> query = em.createNamedQuery(whatDo, Product.class);
            Integer numOfProduct = Integer.parseInt(request.getParameter("quantity"));
            query.setParameter("num", numOfProduct);
            resultList = query.getResultList();
            request.setAttribute("query", whatDo);
            request.setAttribute("products", resultList);
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } else
        {
            String whatDo = request.getParameter("what-do");
            TypedQuery<Product> query = em.createNamedQuery(whatDo, Product.class);
            resultList = query.getResultList();
            request.setAttribute("query", whatDo);
            request.setAttribute("products", resultList);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
