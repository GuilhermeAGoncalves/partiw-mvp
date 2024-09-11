<script setup lang="ts">
import * as z from "zod";
import { Button } from "@/components/ui/button";
import { AutoForm } from "@/components/ui/auto-form";
import { ref, onMounted, shallowRef } from "vue";
import {
  Sheet,
  SheetContent,
  SheetDescription,
  SheetHeader,
  SheetTitle,
  SheetTrigger,
} from "@/components/ui/sheet";

import CategoryService from "@/service/category/CategoryService";
import ContributorsService from "@/service/contribuitor/ContribuitorService";

let schema = shallowRef<z.ZodObject<any, any, any> | any>(null);
let categories = ref<any>([]);

onMounted(async () => {
  let response = await CategoryService.getAllByCompanyId(
    localStorage.getItem("companyId") as any
  );
  categories.value = response;
  const categoryNames = response.map((category: any) => category.name);
  console.log(categoryNames);

  schema.value = z.object({
    Pessoa: z
      .array(
        z.object({
          Nome: z
            .string({
              required_error: "Nome é obrigatorio.",
            })
            .min(2, {
              message: "Nome deve ter no mínimo 2 caracteres.",
            }),
          Cpf: z.string({
            required_error: "Cpf é obrigatorio.",
          }),
          Telefone: z.string({
            required_error: "Cpf é obrigatorio.",
          }),
          Função: z.string({
            required_error: "Função é obrigatorio.",
          }),
          Email: z.string().email({
            message: "Email inválido.",
          }),
          "Data Aniversario": z.coerce.date({
            message: "Data de aniversário inválida.",
          }),
          "Data Férias": z.coerce.date({
            message: "Data de férias inválidas.",
          }),
          Categorias: z
            .enum(categoryNames as [string, ...string[]])
            .describe("Qual a categoria da pessoa?"),
        })
      )
      .describe("Lista de Pessoas"),
  });
});

function onSubmit(values: Record<string, any>) {
  values.Pessoa.forEach((element: any) => {
    let categoryId = categories.value.find(
      (category: any) => category.name === element.Categorias
    ).categoryId;

    ContributorsService.postCreate(
      localStorage.getItem("companyId") as any,
      categoryId,
      {
        name: element.Nome,
        cpf: element.Cpf,
        role: element.Função,
        email: element.Email,
        dtBirth: "2024-09-10 15:30:00",
        dtVacation: "2024-12-01 00:00:00",
        phoneNumber: element.Telefone,
        dtAdmission: "2024-09-10 09:00:00",
        hired: true,
      }
    );
    window.location.reload();
  });
}
</script>

<template>
  <Sheet>
    <SheetTrigger>
      <Button>Adicionar</Button>
    </SheetTrigger>
    <SheetContent style="overflow-y: auto">
      <SheetHeader>
        <SheetTitle>Adicionar Dados</SheetTitle>
        <SheetDescription>
          Adicione os dados dos seus colaboradores.
          <div class="grid w-full max-w-sm items-center gap-1.5 my-4">
            <AutoForm
              class="w-2/3 space-y-6"
              :schema="schema"
              :field-config="{
                Pessoa: {
                  Nome: {
                    inputProps: {
                      placeholder: 'Nome',
                    },
                  },
                },
              }"
              @submit="onSubmit"
            >
              <Button type="submit"> Submit </Button>
            </AutoForm>
          </div>
        </SheetDescription>
      </SheetHeader>
    </SheetContent>
  </Sheet>
</template>
