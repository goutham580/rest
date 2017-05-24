package ezc.test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.security.core.server.csi.IXSSEncoder;
import com.sap.security.core.server.csi.XSSEncoder;

import ezc.model.Distrubutor;

/**
 * Servlet implementing a simple JPA based persistence sample application for SAP Cloud Platform.
 */
public class EzDistTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(EzDistTest.class);

    private DataSource ds;
    private EntityManagerFactory emf;

    /** {@inheritDoc} */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void init() throws ServletException {
        Connection connection = null;
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");

            Map properties = new HashMap();
            properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, ds);
            emf = Persistence.createEntityManagerFactory("JPAProject", properties);
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void destroy() {
        emf.close();
    }

    /** {@inheritDoc} */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<p>Persistence with JPA Sample!</p>");
        try {
            appendDistrubutorTable(response);
            appendAddForm(response);
        } catch (Exception e) {
            response.getWriter().println("Persistence operation failed with reason: " + e.getMessage());
            LOGGER.error("Persistence operation failed", e);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        try {
            doAdd(request);
            doGet(request, response);
        } catch (Exception e) {
            response.getWriter().println("Persistence operation failed with reason: " + e.getMessage());
            LOGGER.error("Persistence operation failed", e);
        }
    }

    private void appendDistrubutorTable(HttpServletResponse response) throws SQLException, IOException {
        // Append table that lists all Distrubutors
        EntityManager em = emf.createEntityManager();
        try {
            @SuppressWarnings("unchecked")
            List<Distrubutor> resultList = em.createNamedQuery("Distrubutor.findAll").getResultList();
            response.getWriter().println(
                    "<p><table border=\"1\"><tr><th colspan=\"3\">"
                            + (resultList.isEmpty() ? "" : resultList.size() + " ")
                            + "Entries in the Database</th></tr>");
            if (resultList.isEmpty()) {
                response.getWriter().println("<tr><td colspan=\"3\">Database is empty</td></tr>");
            } else {
                response.getWriter().println("<tr><th>First name</th><th>Last name</th><th>Id</th></tr>");
            }
            IXSSEncoder xssEncoder = XSSEncoder.getInstance();
            for (Distrubutor p : resultList) {
                response.getWriter().println("<tr><td>" + p.getDistrubutorId() + "</td><td>" + xssEncoder.encodeHTML(p.getName()) + "</td><td>" + p.getCity() + "</td></tr>");
            }
            response.getWriter().println("</table></p>");
        } finally {
            em.close();
        }
    }

    private void appendAddForm(HttpServletResponse response) throws IOException {
        // Append form through which new Distrubutors can be added
        response.getWriter().println(
                "<p><form action=\"\" method=\"post\">" + "First name:<input type=\"text\" name=\"FirstName\">"
                        + "&nbsp;Last name:<input type=\"text\" name=\"LastName\">"
                        + "&nbsp;<input type=\"submit\" value=\"Add Distrubutor\">" + "</form></p>");
    }

    private void doAdd(HttpServletRequest request) throws ServletException, IOException, SQLException {
        // Extract name of Distrubutor to be added from request
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");

        // Add Distrubutor if name is not null/empty
        EntityManager em = emf.createEntityManager();
        try {
            if (firstName != null && lastName != null && !firstName.trim().isEmpty() && !lastName.trim().isEmpty()) {
                Distrubutor Distrubutor = new Distrubutor();
                //Distrubutor.setDistrubutorId(124);
                Distrubutor.setName("1233");
                em.getTransaction().begin();
                em.persist(Distrubutor);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
}