<script setup lang="ts">
import Input from "./ui/input/Input.vue";
import Button from "./ui/button/Button.vue";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "./ui/dropdown-menu";
import { Avatar, AvatarFallback } from "@/components/ui/avatar";

const userName = localStorage.getItem("userName") || "Usuário";

const initUnserName = userName.slice(0, 2).toLocaleUpperCase();

function exit() {
  localStorage.clear();
  window.location.href = "/";
}
</script>

<template>
  <div class="header">
    <div class="header-logo">Partiw</div>
    <div class="header-content">
      <div>
        <Input placeholder="Pesquisar" />
      </div>
      <div>
        <DropdownMenu>
          <DropdownMenuTrigger as-child>
            <Button variant="outline">
              <Avatar class="relative h-8 w-8 mr-1 rounded-full">
                <AvatarFallback>{{ initUnserName }}</AvatarFallback>
              </Avatar>
              {{ userName }}
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent>
            <DropdownMenuLabel>{{ userName }}</DropdownMenuLabel>
            <DropdownMenuSeparator />
            <DropdownMenuItem @click="exit"> Sair</DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      </div>
    </div>
  </div>
</template>

<style>
.header {
  display: flex;
}

.header-logo {
  width: 10svw;
  font-size: 1.5rem;
  font-weight: bold;
  padding: 10px;
  background-color: #f8f9f9;
}

.header-content {
  width: 85svw;
  background-color: #fbfbfc;
  padding: 10px 0;
  display: flex;
  justify-content: space-around;
}
</style>
