<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal">&times;</button>
  <h4 class="modal-title">Novo usuário</h4>
</div>

<div class="modal-body">
	<input type="text" placeholder="Nome completo" ng-model="currentUser.completeName"/>
	<input type="text" placeholder="cpf" ng-model="currentUser.cpf"/>
	<input type="date" ng-model="currentUser.birthDate"/>

	<input type="text" placeholder="login" ng-model="currentUser.login.userName"/>
	<input type="text" placeholder="senha" ng-model="currentUser.login.userPassword"/>

	<input type="text" placeholder="país" ng-model="currentUser.address.country"/>
	<input type="text" placeholder="estado" ng-model="currentUser.address.uf"/>
	<input type="text" placeholder="Cidade" ng-model="currentUser.address.city"/>
	<input type="text" placeholder="Bairro" ng-model="currentUser.address.neighborhood"/>
	<input type="text" placeholder="rua" ng-model="currentUser.address.street"/>
	<input type="text" placeholder="numero" ng-model="currentUser.address.number"/>
</div>