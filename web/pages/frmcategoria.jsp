<div class="col-md-12">            
    <div class="card card-primary">
      <div class="card-header">
        <h3 class="card-title">Cadastro de Categoria</h3>
      </div>      
      <form role="form" >
          <input type="hidden" name="ac" value="saveCategoria" />
        <div class="card-body">
          <div class="form-group">
            <label for="cpDescricao">Descrição:</label>
            <input type="text" class="form-control" id="cpDescricao" name="cpDescricao" >
          </div>
              <div class="form-group">
                <label>Detalhe:</label>
                <textarea class="form-control" rows="3" placeholder="Detalhe" name="cpDetalhe"></textarea>
              </div> 

        </div>
        <div class="card-footer">
          <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>   
</div>