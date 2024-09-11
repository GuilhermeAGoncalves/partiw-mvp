<template>
  <div class="siderbar">
    <router-link to="/dashboard">Dashboard</router-link>
    <router-link to="/users">Usuários</router-link>
    <router-link to="/products">Pedidos</router-link>
  </div>
</template>
<script setup lang="ts"></script>

<style>
.siderbar {
  width: 10svw;
  height: calc(100vh - 70px); /* Altura da barra lateral */
  overflow-y: auto; /* Adiciona scroll se necessário */
  display: flex;
  flex-direction: column;
}

.siderbar a {
  padding-left: 20px;
  margin-bottom: 10px;
}
</style>
