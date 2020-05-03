<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                      <a href="" id="opDel${desp.id}" data-id="${desp.id}">
                          <i class="fa fa-minus-circle" title="apagar despesa" ></i></a>                        
                  </td>
          </tr>
      </c:forEach>                             
    </tbody>
  </table>