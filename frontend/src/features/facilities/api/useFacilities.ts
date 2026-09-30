import type { Facility } from "@/features/facilities/types"
import { apiClient } from "@/lib/axios.ts"
import { useQuery } from "@tanstack/react-query"

export const getFacilities = (): Promise<Facility[]> => {
  return apiClient.get("/facilities");
}

export const useFacilities = ()=>{
  return useQuery({
    queryKey: ['facilities'],
    queryFn: getFacilities,
  })
}