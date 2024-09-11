<template>
  <div class="login-container">
    <div class="login-image">
      <div
        style="
          flex: 1;
          display: flex;
          flex-direction: column;
          justify-content: flex-end;
        "
      >
        <h1 style="font-size: 2rem; font-weight: bold">Partiw</h1>
        <p style="font-size: 0.75rem; width: 75%">
          A plataforma que ofere o melhor béneficio para seus colaboradores
          viajarem mais barato.
        </p>
      </div>

      <div
        style="
          flex: 1;
          display: flex;
          flex-direction: column;
          justify-content: flex-end;
        "
      >
        <div
          style="
            display: flex;
            padding-bottom: 1rem;
            font-size: 0.85rem;
            display: flex;
            justify-content: space-between;
          "
        >
          <span> partiw version 0.0.1 @ 2024 </span>
          <div style="padding-right: 2rem">
            <span style="margin-right: 0.5rem">Termos</span>
            <span>Contato</span>
          </div>
        </div>
      </div>
    </div>
    <div class="login-form">
      <div class="login-form-info">
        <div style="text-align: center; margin-bottom: 2rem">
          <h1 class="login-form-info-partiw">Login</h1>
          <p>Entre com sua conta</p>
        </div>
        <div>
          <Input type="email" placeholder="Email" v-model="email" />
          <Input
            type="password"
            placeholder="Senha"
            @keyup.enter="login"
            v-model="password"
          />
        </div>
        <div style="display: flex; justify-content: flex-end">
          <Button @click="login">Entrar</Button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import UsersService from "@/service/users/UsersService";
import { useToast } from "@/components/ui/toast/use-toast";

const email = ref("");
const password = ref("");

const router = useRouter();
const { toast } = useToast();

const login = async () => {
  const loginResult = await UsersService.login(email.value, password.value);
  console.log(loginResult);
  localStorage.setItem("companyId", loginResult.company.companyId);
  localStorage.setItem("userName", loginResult.name);

  if (loginResult) {
    router.push("/dashboard");
  } else {
    toast({
      title: "Erro",
      description: "Email ou senha inválidos",
    });
  }
};
</script>

<style>
.login-container {
  display: flex;
  height: 100vh;
}

.login-image {
  display: flex;
  flex-direction: column;
  width: 35svw;
  padding-left: 2rem;
  background: url("../assets/FOTO-1.jpg") no-repeat;
  background-size: cover;
  height: 100%;

  /* Estilos adicionais para a imagem de fundo */
}

.login-form {
  width: 65svw;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  /* Estilos adicionais para o formulário de login */
}

.login-form-info {
  width: 50%;
  margin: 0 auto;
}

.login-form-info-partiw {
  font-size: 2rem;
  font-weight: bold;
}

.login-form input {
  margin-bottom: 1rem;
}

.login-form button {
  padding: 1rem 1.5rem;
}
</style>
@/service/User/UsersService @/service/users/UsersService
