package edu.kirkwood.java2eedemo;

import edu.kirkwood.shared.email.EmailThread;
import edu.kirkwood.shared.Validators;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/contact")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String toEmailAddress = req.getParameter("toEmailAddress");
        String subject = req.getParameter("subject");
        String bodyHTML = req.getParameter("bodyHTML");
        String replyTo = toEmailAddress;

        req.setAttribute("toEmailAddress", toEmailAddress);
        req.setAttribute("subject", subject);
        req.setAttribute("bodyHTML", bodyHTML);
        req.setAttribute("replyTo", replyTo);

        boolean error = false;
        String emailError = "";
        String subjectError = "";
        String messageBodyError = "";


        if(toEmailAddress == null || !Validators.isValidEmail(toEmailAddress)) {
            // set error attribute
            emailError = "Invalid email address: " + toEmailAddress;
            error = true;
        }

        if(subject == null || subject.isEmpty()) {
            // set error attribute
            subjectError = "Subject is required";
            error = true;
        }

        if(bodyHTML == null || bodyHTML.isEmpty()) {
            // set error attribute
            messageBodyError = "Body is required";
            error = true;
        }

        if (error) {

            req.setAttribute("emailError", emailError);
            req.setAttribute("subjectError", subjectError);
            req.setAttribute("messageBodyError", messageBodyError);
            req.getRequestDispatcher("contact.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("toEmailAddress", null);
        req.setAttribute("subject", null);
        req.setAttribute("bodyHTML", null);

        EmailThread emailThread1 = new EmailThread(toEmailAddress, subject, bodyHTML, replyTo);
        emailThread1.start();
        EmailThread emailThread2 = new EmailThread("elise.hrabik@gmail.com", subject, bodyHTML, replyTo);
        emailThread2.start();

            try {
                emailThread1.join();
                emailThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace(); // given as automatic suggestion from Intellij
            }

            String errorMessage1 = emailThread1.getErrorMessage();
            String errorMessage2 = emailThread2.getErrorMessage();

            if (errorMessage1.isEmpty() && errorMessage2.isEmpty()) {
                req.setAttribute("messageSuccess","Message sent!");
            } else {
                req.setAttribute("emailError", "Message not sent. " + errorMessage1);
            }
        // Forward req/resp to a JSP
        req.getRequestDispatcher("contact.jsp").forward(req, resp);
    }
}


