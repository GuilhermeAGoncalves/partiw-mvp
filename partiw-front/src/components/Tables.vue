<script setup lang="ts">
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { ref, onMounted } from "vue";
import ContribuitorService from "@/service/contribuitor/ContribuitorService";
import { ContribuitorResponse } from "@/service/contribuitor/types";

const contribuitors = ref<ContribuitorResponse[]>([]);
const emit = defineEmits<{
  (e: "contribuitors", reponse: ContribuitorResponse[]): void;
}>();

onMounted(async () => {
  let response = await ContribuitorService.getAllContribuitors();
  contribuitors.value = response || [];
  emit("contribuitors", response);
});
</script>

<template>
  <Table>
    <TableHeader>
      <TableRow>
        <TableHead> Nome </TableHead>
        <TableHead> Email </TableHead>
        <TableHead> Categoria </TableHead>
        <TableHead> Cargo </TableHead>
        <TableHead class="text-right"> Ativo na empresa </TableHead>
      </TableRow>
    </TableHeader>
    <TableBody>
      <TableRow v-for="(contribuitor, index) in contribuitors" :key="index">
        <TableCell class="font-medium"> {{ contribuitor.name }} </TableCell>
        <TableCell>{{ contribuitor.email }}</TableCell>
        <TableCell>{{ contribuitor.category.name }}</TableCell>
        <TableCell>{{ contribuitor.role }}</TableCell>
        <TableCell class="text-right"> {{ contribuitor.hired }} </TableCell>
      </TableRow>
    </TableBody>
  </Table>
</template>
