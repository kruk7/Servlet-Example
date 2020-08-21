package servlet;

import model.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/products")
public class ProductServlet extends HttpServlet
{
    @Inject
    private EntityManager em;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean add = Boolean.parseBoolean(request.getParameter("add"));
        if (add)
        {
            addProduct(request);
            response.sendRedirect(request.getContextPath());
        } else
        {
            getProducts(request);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }

    private void addProduct(HttpServletRequest request)
    {
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productCategory = request.getParameter("productCategory");
        Product product = new Product(productName, productPrice, productCategory);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(product);
        tx.commit();
    }

    private void getProducts(HttpServletRequest request)
    {
        String userQuery = request.getParameter("query");
        TypedQuery<Product> query = em.createQuery(userQuery, Product.class);
        List<Product> resultList = query.getResultList();
        request.setAttribute("query", userQuery);
        request.setAttribute("products", resultList);
    }
}