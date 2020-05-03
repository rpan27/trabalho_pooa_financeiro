<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Livros du Zezin</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="icon" href="img/favicon.png" />

        <!-- Bootstrap core CSS -->
                    
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css" integrity="sha256-BJ/G+e+y7bQdrYkS2RBTyNfBHpA9IuGaPmf9htub5MQ=" crossorigin="anonymous" />
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" integrity="sha256-h20CPZ0QyXlBuAw7A+KluUYx/3pK+c7lYEpqLTlxjYQ=" crossorigin="anonymous" />

            <script src="https://code.jquery.com/jquery-3.5.0.min.js" ></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>

            <script src="js/jquery.mask.min.js"></script>

    </head>
<body>   

<div id="dvExclusao" name="dvExclusao" >&nbsp;</div>    
<div class="card-body table-responsive p-0">
  <table class="table table-hover text-nowrap">
    <thead>
      <tr>                                           
        <th>Data</th>
        <th>Descrição</th>
        <th>Valor(R$)</th>
        <th>Paga?</th>                     
        <th>Ações</th>                     
      </tr>
    </thead>
    <tbody>                  
      <c:forEach items="${requestScope.lista}" var="desp" >
          <tr>
              <td>${desp.dataFormatada}</td>                                         
              <td>${desp.descricao}</td>                            
              <td>${desp.valor}</td>                                   
              <c:if test="${desp.foiPaga == false}" >
                  <td><i class="fa fa-ban" aria-hidden="true" title="Não" ></td>      
              </c:if>
              <c:if test="${desp.foiPaga != false}" >
                  <td><i class="fa fa-check" title="Sim" ></td>      
              </c:if>
                   <td>
                      <a href="app?ac=editDespesa&id=${desp.id}"> 
                          <i class="fa fa-edit" title="alterar despesa" ></i></a>
                      <a href="#" id="opDel${desp.id}" data-id="${desp.id}">
                          <i class="fa fa-minus-circle" title="apagar despesa" ></i></a>                        
                  </td>
          </tr>
      </c:forEach>                             
    </tbody>
  </table>
</div>

      
<script type="text/javascript">

      $(function () {
          $('[data-toggle="popover"]').popover();
      });

      $(document).ready(function () {
          $(".navbar-toggle").click(function () {
              $(".sidebar").toggleClass("sidebar-open");
          })
      });
      
    $('a[id*="opDel"]').on("click", function () {
            $.ajax({
                type: "POST",    
                url: "app?ac=delDespesa",
                data: {'id' : $(this).data('id') },    
                cache: false,
                timeout: 600000,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    $("#dvExclusao").html(data);
                },
                error: function (e) {

                    var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                            + e.responseText + "&lt;/pre&gt;";                    

                    console.log("ERROR : ", json);
                    console.log("ERROR : ", e);
                    alert("Não conseguimos buscar a exclusão")

                }
            });
        });    

</script>
    </body>
</html>