<script setup lang="ts">
import Header from "@/components/Header.vue";
import Tables from "@/components/Tables.vue";
import DateRangePick from "@/components/DateRangePick.vue";

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import SheetImport from "./SheetImport.vue";
import { ref } from "vue";

const constribuitors = ref([]);

const getContribuitors = (response: any) => {
  constribuitors.value = response;
};

const userName = localStorage.getItem("userName");
</script>
<template>
  <div class="dashboard">
    <Header />
    <div class="header-sidebar">
      <div class="dashboard-content">
        <div class="dashboard-welcome">
          <div>
            <h2 class="text-2xl font-bold tracking-tight">Dashboard</h2>
            <p class="text-muted-foreground">
              Seja bem vindo!
              <span style="font-weight: bold"> {{ userName }} </span>, tudo
              parece ótimo.
            </p>
          </div>
          <div class="flex">
            <DateRangePick />
            <div class="ml-2">
              <SheetImport />
            </div>
          </div>
        </div>
        <div class="space-y-3">
          <div class="grid gap-4 md:grid-cols-1">
            <Card class="col-span-3">
              <CardHeader>
                <CardTitle>Funcionários cadastrado na Partiw</CardTitle>
                <CardDescription>
                  {{ constribuitors.length }} funcionários
                </CardDescription>
              </CardHeader>
              <CardContent>
                <Tables @contribuitors="getContribuitors" />
              </CardContent>
            </Card>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<style>
.header-sidebar {
  display: flex;
}

.dashboard-content {
  background-color: #f0f1f2;
  flex: 1;
  padding: 30px 80px 0px 80px;
  height: 93vh;
}

.dashboard-welcome {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 10px;
  margin-bottom: 20px;
}
</style>
