<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="UTF-8"%>

<div ng-controller="medicRegisterCtrl">
	<section class="mdl-shadow--4dp section-main-page">
		<div class="mdl-card mdl-cell mdl-cell--12-col mdl-card__supporting-text">
			<h4 class="card-title">Consultar</h4>

			<div class="container mdl-card-container">
				<div class="row">
					<div class="col-md-4">
						<select ng-options="optionParam.name for optionParam in selectionParams" ng-model="optionParam" style="width:100%!" ng-change="setSelectionParam(optionParam)">
							<option value="">Escolha uma opção para a busca</option>
						</select>
					</div>

					<div class="col-md-4" >
						<input ng-model="paramSearchValue" type="text" style="width:100%" ng-show="currentSelectionParam == 1" placeholder="CPF"/>
						<input ng-model="paramSearchValue" type="text" style="width:100%" ng-show="currentSelectionParam == 2" placeholder="RG"/>
						<input ng-model="paramSearchValue" type="text" style="width:100%" ng-show="currentSelectionParam == 3" placeholder="CNS"/>
					</div>

					<div class="col-md-4">
						<button style="width:100%" class="btn btn-primary" ng-click="getPacientRegisters()">Consultar</button>
					</div>
				</div>
			</div>	
		</div>
	</section>
</div>